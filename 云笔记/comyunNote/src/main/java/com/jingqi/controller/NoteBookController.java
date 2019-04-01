package com.jingqi.controller;

import com.jingqi.Common;
import com.jingqi.domain.NoteBook;
import com.jingqi.domain.User;
import com.jingqi.service.NoteBookService;
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
 * 笔记本controller层
 * @author  Huxudong
 * @date    2019-02-10
 */
@Controller
public class NoteBookController implements Common {
    @Autowired
    private NoteBookService noteBookService;

    /**
     * 一开始自动点击事件的标志
     */
    private String flag;

    /**
     * 查询所有的笔记本
     * @author          Huxudong
     * @date            2019-02-15
     * @param model     绑定的model对象
     * @param session   记录用户信息的session对象
     * @return          查询页面信息
     */
    @RequestMapping("/findAllNoteBooks.do")
    public String findAllNoteBooks(Model model, HttpSession session, Page page, String noteBookName, String noteBookType, HttpServletRequest request) {
        User user = (User)session.getAttribute("SESSION");
        String roles = request.getParameter("roles");
        String userId = user.getUserId();
        if(null != noteBookName) {
            noteBookName = noteBookName.trim();
        }
        if(null != noteBookType) {
            noteBookType = noteBookType.trim();
        }
        if((SYSADMIN).equals(roles) || (COMMINADMIN).equals(roles)) {
            userId = null;
        }
        // 总页数
        int totalPage ;
        flag = "3";
        // 总记录数
        int count = this.noteBookService.findCount(userId,noteBookName,noteBookType);
        // 判断是否是整数
        if(count % page.getPageSize() == 0) {
            // 总页数
            totalPage = count / page.getPageSize();
            // 如果一开始没有数据则count为0,那么totalPage也为0，但是在page类中的分页初始是减1的，所以会造成初始分页为负值，不符合逻辑，所以当totalpage为0时要加1
            if(totalPage == 0) {
                totalPage = totalPage + 1;
            }
        } else {
            // 总页数
            totalPage = count / page.getPageSize() + 1;
        }

        List<NoteBook> noteBooks = this.noteBookService.findAll(userId,noteBookName,noteBookType,page.getBegin(),page.getPageSize());
        model.addAttribute("noteBook",noteBooks);
        model.addAttribute("totalPage",totalPage);
        if(!(NULL).equals(noteBookName)) {
            model.addAttribute("noteBookName",noteBookName);
        }
        if(!(NULL).equals(noteBookType)) {
            model.addAttribute("noteBookType",noteBookType);
        }
        model.addAttribute("roles",roles);
        model.addAttribute("currentPage",page.getCurrentPage());
        model.addAttribute("flag",flag);
        return "query";
    }

    /**
     * 创建笔记本并返回json对象的信息
     * @author           Huxudong
     * @date             2019-02-15
     * @param noteBookType   前端页面传过来的笔记本类型
     * @param noteBookName   前端页面传过来的笔记本名称
     * @param noteBookDescription  前端传过来的笔记本描述
     * @param session         记录用户信息的session的对象
     * @return                json数据(OK:代表新增数据成功的标志,FAIL:代表数据新增失败的标志,NOT:代表如果前端的笔记本名称为空时,返回给前端的提示的标志)
     */
    @RequestMapping(value = "/createNoteBook.do")
    @ResponseBody
    public String createNoteBook(String noteBookType,String noteBookName,String noteBookDescription,HttpSession session) {
        if(null == noteBookName || ("").equals(noteBookName)) {
            // 如果笔记本名称为空返回json标志
            return "NOT";
        }
        // 根据笔记本名称查询笔记本实体类信息
        NoteBook noteBook = this.noteBookService.findByNoteBookName(noteBookName);
        if(null != noteBook) {
            // 如果该笔记本名称已经存在返回的json标志
            return "EXIT";
        }
        User user = (User)session.getAttribute("SESSION");
        String userId = user.getUserId();
        String userName = user.getUserName();
        int row = this.noteBookService.createBook(noteBookType,noteBookName,noteBookDescription,userId,userName);
        if(row == 1) {
            // 创建成功后返回的json标志
            return "OK";
        }
        // 创建失败后返回的json标志
       return "FAIL";
    }

    /**
     * 根据笔记本id查询该笔记本信息映射到前端页面并返回json对象
     * @author         Huxudong
     * @date           2019-02-15
     * @param id       前端传过来的笔记本的id
     * @return         json对象信息
     */
    @RequestMapping(value = "/editNoteBook.do")
    @ResponseBody
    public NoteBook editNoteBook(String id) {
       NoteBook noteBook = this.noteBookService.findById(id);
       return noteBook;
    }

    /**
     * 删除笔记本并返回json信息
     * @author        Huxudong
     * @data          2019-02-16
     * @param id       前端穿过来的笔记本的id
     * @return         json对象信息(OK:表示删除数据成功的标志,FAIL:表示删除数据失败的标志)
     */
    @RequestMapping(value = "/recycleNoteBook.do")
    @ResponseBody
    public String recycleNoteBook(String id,HttpSession session) {
        User user =(User) session.getAttribute("SESSION");
        int row = this.noteBookService.recycleBookById(id,user);
        if(row > 0) {
            // 删除笔记本成功后返回的json标志
            return "OK";
        }
        // 删除笔记本失败后返回的json标志
        return "FAIL";
    }

    /**
     * 保存修改的笔记本的信息
     * @author   Huxudong
     * @date     2019-02-16
     * @param noteBookType    前端传过来的笔记本的类型
     * @param noteBookName    前端传过来的笔记本的名称
     * @param noteBookDescription  前端传过来的笔记本的描述
     * @return                 json对象信息(EXIST:表示前端修改的笔记本名称在数据库中已经存在的标志，OK:表示修改数据成功的标志,FAIL:表示修改数据失败的标志)
     */
    @RequestMapping(value = "/save.do")
    @ResponseBody
    public String save(String noteBookId,String noteBookType,String noteBookName,String noteBookDescription,HttpSession session) {
        // 根据笔记本名称查询笔记本实体类
        NoteBook noteBook = this.noteBookService.findByNoteBookName(noteBookName);
        // 根据笔记本的id查询笔记本实体类信息
        NoteBook noteBook1 = this.noteBookService.findById(noteBookId);
        // 如果修改笔记本时，笔记本名称不变也可以修改
        if(!(noteBookName).equals(noteBook1.getNoteBookName())) {
            if(null != noteBook) {
                // 如果修改的笔记本名称在数据库中已经存在返回的json标志（笔记本名称除去该笔记本的id在该数据库中的笔记本名称)
                return "EXIST";
            }
        }

        User user = (User)session.getAttribute("SESSION");
        int row = this.noteBookService.update(noteBookId,noteBookType,noteBookName,noteBookDescription,user);
        if(row > 0) {
            // 保存成功后返回的json标志
            return "OK";
        }
        // 保存失败后返回的json标志
        return "FAIL";
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
}
