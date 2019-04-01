package com.jingqi.controller;

import com.jingqi.Common;
import com.jingqi.domain.Note;
import com.jingqi.domain.NoteBook;
import com.jingqi.domain.User;
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
 * 回收站controller层
 * @author    Huxudong
 * @date      2019-02-19
 */
@Controller
public class BackController implements Common {
    @Autowired
    private NoteService noteService;
    @Autowired
    private NoteBookService noteBookService;

    /**
     * 一开始加载时自动点击事件标志
     */
    private String flag;
    /**
     * 显示回收站中所有的笔记本
     * @param model           model对象
     * @param session         用户的session对象
     * @param page            分页的page实体类
     * @param noteBookName    笔记本名称
     * @param noteBookType    笔记本类型
     * @author                Huxudong
     * @date                  2919-02-16
     * @return                回收站中所有的笔记本的列表集合
     */
    @RequestMapping(value = "/noteBookBack.do")
    public String noteBookBack(Model model, HttpSession session, Page page, String noteBookName, String noteBookType, HttpServletRequest request) {
        User user = (User)session.getAttribute("SESSION");
        String userId = user.getUserId();
        // 总页数
        int totalPage ;
        flag = "4";
        String roles = request.getParameter("roles");
        String updator = user.getUserId();
        if((SYSADMIN).equals(roles) || (COMMINADMIN).equals(roles)) {
            userId = null;
            updator = null;

        }
        // 总记录数
        int count = this.noteBookService.findCountBack(userId,noteBookName,noteBookType,updator);
        if(count % page.getPageSize() == 0) {
            // 总页数
            totalPage = count / page.getPageSize();
            if(totalPage == 0) {
                totalPage = totalPage -1 +2;
            }
        } else {
            // 总页数
            totalPage = count / page.getPageSize() + 1;
        }

        List<NoteBook> noteBooks = this.noteBookService.findAllBack(userId,noteBookName,noteBookType,updator,page.getBegin(),page.getPageSize());
        model.addAttribute("noteBook",noteBooks);
        model.addAttribute("totalPage",totalPage);
        model.addAttribute("noteBookName",noteBookName);
        model.addAttribute("noteBookType",noteBookType);
        model.addAttribute("currentPage",page.getCurrentPage());
        model.addAttribute("roles",roles);
        model.addAttribute("flag",flag);
        return "noteBookBack";
    }

    /**
     * 根据笔记本的id查询笔记本的实体类并返回json对象
     * @param id           笔记本的id
     * @author             Huxudong
     * @date               2019-02-16
     * @return             笔记本实体类的json对象
     */
    @RequestMapping(value = "/BookNoteLookBack.do")
    @ResponseBody
    public NoteBook bookNoteLookBack(String id) {
        NoteBook noteBook = this.noteBookService.findById(id);
        return noteBook;
    }

    /**
     * 删除笔记本并返回json信息
     * @author         Huxudong
     * @data           2019-02-16
     * @param id       前端穿过来的笔记本的id
     * @return         json对象信息(OK:表示删除数据成功的标志,FAIL:表示删除数据失败的标志)
     */
    @RequestMapping(value = "/deleteBookBack.do")
    @ResponseBody
    public String deleteBookBack(String id) {
        int row = this.noteBookService.deleteBookById(id);
        if(row > 0) {
            // 删除笔记本成功后返回的json标志
            return "OK";
        }
        // 删除笔记本失败后返回的json标志
        return "FAIL";
    }

    /**
     * 查询回收站中所有笔记的列表
     * @param model        model对象
     * @param session      用户的session对象
     * @param page         封装的分页的实体类
     * @param noteType     笔记类型
     * @param noteTitle    笔记标题
     * @author             Huxudong
     * @date               2019-02-16
     * @return             回收站中所有的笔记的列表的集合
     */
    @RequestMapping(value = "/noteBack.do")
    public String noteBack(Model model, HttpSession session, Page page, String noteType, String noteTitle,HttpServletRequest request) {
        User user = (User) session.getAttribute("SESSION");
        String userId = user.getUserId();
        String roles = request.getParameter("roles");
        String updator = user.getUserId();
        if((SYSADMIN).equals(roles) || (COMMINADMIN).equals(roles)) {
            userId = null;
            updator = null;
        }
        // 总页数
        int totalPage;
        flag = "5";
        // 总记录数
        int count = this.noteService.findNoteCountBack(userId,noteType,noteTitle,updator);
        if(count % page.getPageSize() == 0) {
            // 总页数
            totalPage = count / page.getPageSize();
            if(totalPage == 0) {
                totalPage = totalPage -2 + 3;
            }
        } else {
            // 总页数
            totalPage = count / page.getPageSize() + 1;
        }
        List<Note> note = this.noteService.findAllNoteBack(userId,noteType,noteTitle,updator,page.getBegin(),page.getPageSize());
        model.addAttribute("note",note);
        model.addAttribute("totalPage",totalPage);
        model.addAttribute("noteType",noteType);
        model.addAttribute("noteTitle",noteTitle);
        model.addAttribute("currentPage",page.getCurrentPage());
        model.addAttribute("roles",roles);
        model.addAttribute("flag",flag);
        return "noteBack";
    }

    /**
     * 还原回收站笔记并返回json数据
     * @param id              笔记的id
     * @param session         用户登录的session对象
     * @return                json的数据提示
     */
    @RequestMapping(value = "/restoreNote.do")
    @ResponseBody
    public String restoreNote(String id,HttpSession session) {
        User user = (User)session.getAttribute("SESSION");
        Note note = this.noteService.findByNoteId(id);
        String noteBookId = note.getNoteBookId();
        NoteBook noteBook = this.noteBookService.findById(noteBookId);
        if((NOTEBOOKBACKSTATUSZERO).equals(noteBook.getNoteBookStatus())) {
            // 如果该笔记所在的笔记本已经被放入回收站了，则提示该笔记本已经放入回收站，请先还原该笔记本
            return "NOTEXIST";
        }
        int row = this.noteService.restoreNote(id,user);
        if(row > 0) {
            // 还原成功的json提示的标志
            return "OK";
        }
        // 还原失败的json提示标志
        return "FAIL";
    }

    /**
     * 还原回收站笔记本并返回json对象
     * @param id                笔记本的id
     * @param session           用户登录的session对象
     * @return                  json的提示数据
     */
    @RequestMapping(value = "/restoreBook.do")
    @ResponseBody
    public String restoreBook(String id,HttpSession session) {
        User user =(User) session.getAttribute("SESSION");
        int row = this.noteBookService.restoreBook(id,user);
        if(row > 0) {
            // 还原成功的json提示的标志
            return "OK";
        }
        // 还原失败的json提示标志
        return "FAIL";
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
}
