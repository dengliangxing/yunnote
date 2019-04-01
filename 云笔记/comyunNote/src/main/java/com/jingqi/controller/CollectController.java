package com.jingqi.controller;
import com.jingqi.Common;
import com.jingqi.domain.Collect;
import com.jingqi.domain.Note;
import com.jingqi.domain.NoteBook;
import com.jingqi.domain.User;
import com.jingqi.service.CollectService;
import com.jingqi.service.NoteBookService;
import com.jingqi.service.NoteService;
import com.jingqi.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 收藏controller层
 * @author   Huxudong
 * @date     2019-02-20
 */
@Controller
public class CollectController implements Common {
    @Autowired
    private CollectService collectService;
    @Autowired
    private NoteBookService noteBookService;
    @Autowired
    private NoteService noteService;
    /**
     * 一开始触发的点击事件标志
     */
    private String flag;
    /**
     * 查询所有的收藏的笔记本列表
     * @param model      绑定的model对象
     * @param page       分页的page对象
     * @param session    用户登录的session对象
     * @return           收藏的笔记本的列表
     */
    @RequestMapping(value = "/collectNoteBook.do")
    public String collectNoteBook(Model model, Page page, HttpSession session, HttpServletRequest request) {
        User user = (User)session.getAttribute("SESSION");
        String userId = user.getUserId();
        String roles = request.getParameter("roles");
        if((SYSADMIN).equals(roles) || (COMMINADMIN).equals(roles)) {
            userId = null;
        }
        // 总页数
        int totalPage ;
        flag = "7";
        // 总记录数
        int count = this.collectService.findCollectCount(userId);
        if(count % page.getPageSize() == 0) {
            totalPage = count / page.getPageSize();
            if(totalPage == 0) {
                totalPage = totalPage + 2 - 1;
            }
        } else {
            totalPage = count / page.getPageSize() + 1;
        }
        List<Collect> collects = this.collectService.findAllCollect(userId,page.getBegin(),page.getPageSize());
        model.addAttribute("totalPage",totalPage);
        model.addAttribute("collects",collects);
        model.addAttribute("currentPage",page.getCurrentPage());
        model.addAttribute("roles",roles);
        model.addAttribute("flag",flag);
        return "collectionNoteBook";
    }


    /**
     * 查询所有的收藏的笔记的列表
     * @param model      绑定的model对象
     * @param page       分页的page对象
     * @param session    用户登录的session对象
     * @return           收藏的笔记的列表
     */
    @RequestMapping(value = "/collectNote.do")
    public String collectNote(Model model,Page page,HttpSession session,HttpServletRequest request) {
        User user = (User)session.getAttribute("SESSION");
        String userId = user.getUserId();
        String roles = request.getParameter("roles");
        if((SYSADMIN).equals(roles) || (COMMINADMIN).equals(roles)) {
            userId = null;
        }
        // 总页数
        int totalPage;
        flag = "7";
        // 总记录数
        int count = this.collectService.findCollectNoteCount(userId);
        if(count % page.getPageSize() == 0) {
            totalPage = count / page.getPageSize();
            if(totalPage == 0) {
                totalPage = totalPage + 3 - 2;
            }
        } else {
            totalPage = count / page.getPageSize() + 1;
        }
        List<Collect> collect = this.collectService.findAllCollectNote(userId,page.getBegin(),page.getPageSize());
        model.addAttribute("totalPage",totalPage);
        model.addAttribute("collect",collect);
        model.addAttribute("currentPage",page.getCurrentPage());
        model.addAttribute("roles",roles);
        model.addAttribute("flag",flag);
        return "collectionNote";
    }
    /**
     * 根据笔记本的id收藏该笔记本
     * @param id          收藏的笔记本的id
     * @param session     用户登录的session对象
     * @author            Huxudong
     * @date              2019-02-21
     * @return            json数据信息
     */
    @RequestMapping(value = "/collectOneNoteBook.do")
    @ResponseBody
    public String collectOneNoteBook(String id, HttpSession session) {
        User user = (User) session.getAttribute("SESSION");
        NoteBook noteBook = this.noteBookService.findById(id);
        int bookRow = this.collectService.collectNoteBook(noteBook,user);
        if(bookRow > 0) {
            return "OK";
        }
        return "FAIL";
    }

    /**
     * 删除一条收藏的笔记本
     * @author            Huxudong
     * @date              2019-02-21
     * @param id          收藏的笔记本的id
     * @return            json数据信息
     */
    @RequestMapping(value = "/deleteCollectNoteBook.do")
    @ResponseBody
    public String deleteCollectNoteBook(String id) {
        int row = this.collectService.deleteCollect(id);
        if(row > 0) {
            return "OK";
        }
        return "FAIL";
    }

    /**
     * 删除一条收藏的笔记
     * @author            Huxudong
     * @date              2019-02-21
     * @param id          收藏的笔记的id
     * @return            json的数据信息
     */
    @RequestMapping(value = "/deleteCollectNote.do")
    @ResponseBody
    public String deleteCollectNote(String id) {
        int row = this.collectService.deleteCollect(id);
        if(row > 0) {
            return "OK";
        }
        return  "FAIL";
    }

    /**
     * 查看收藏的笔记本的信息
     * @author           Huxudong
     * @date             2019-02-21
     * @param id         收藏的笔记本的id
     * @return           json数据信息
     */
    @RequestMapping(value = "/lookBookNote.do")
    @ResponseBody
    public Collect lookBookNote(String id) {
        Collect collect = this.collectService.lookBookNote(id);
        return collect;
    }

    /**
     * 查看收藏的笔记的信息
     * @author           Huxudong
     * @date             2019-02-21
     * @param id         收藏的笔记的id
     * @return           json数据的信息
     */
    @RequestMapping(value = "/lookCollectNote.do")
    @ResponseBody
    public Collect lookCollectNote(String id) {
        Collect collect = this.collectService.lookBookNote(id);
        return  collect;
    }

    /**
     * 收藏一个笔记
     * @author           Huxudong
     * @date             2019-02-21
     * @param id         收藏一个笔记
     * @return           json数据信息
     */
    @RequestMapping(value = "/collectOneNote.do")
    @ResponseBody
    public String collectOneNote(String id,HttpSession session) {
        User user = (User)session.getAttribute("SESSION");
        Note note = this.noteService.findByNoteId(id);
        int row = this.collectService.collectNote(note,user);
        if(row > 0) {
            return "OK";
        }
        return "FAIL";

    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
}
