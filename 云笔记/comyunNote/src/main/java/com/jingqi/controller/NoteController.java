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
 * 笔记的controller
 * @author   Huxudong
 * @date     2019-02-18
 */
@Controller
public class NoteController implements Common {
    @Autowired
    private NoteService noteService;
    @Autowired
    private NoteBookService noteBookService;

    /**
     * 一开始自动点击标志
     */
    private String flag;
    /**
     * 分页查询所有笔记
     * @author             Huxudong
     * @date               2019-02-18
     * @param model        绑定页面的Model对象
     * @param session      用户的session对象
     * @param request      request请求
     * @param page         分页实体类
     * @return             所有笔记的list集合的页面显示
     */
    @RequestMapping(value = "/includeBookNote.do")
    public String includeBookNote(Model model, HttpSession session, HttpServletRequest request, Page page,String noteType,String noteTitle) {
        String noteBookId = request.getParameter("noteBookId");
        String collect = request.getParameter("collect");
        String collectFlag = request.getParameter("collectFlag");
        String roles = request.getParameter("roles");
        User user = (User) session.getAttribute("SESSION");
        String userId = user.getUserId();
        if(null != noteType) {
            noteType = noteType.trim();
        }
        if(null != noteTitle) {
            noteTitle = noteTitle.trim();
        }
        if((SYSADMIN).equals(roles) || (COMMINADMIN).equals(roles)) {
            userId = null;
        }
        NoteBook noteBook = this.noteBookService.findById(noteBookId);
        String noteBookTitle = null;
        if(null != noteBook) {
            noteBookTitle = noteBook.getNoteBookName();
        }

        // 总页数
        int totalPage;

        if(("collectFlag").equals(collectFlag)) {
            flag = "8";
        } else {
            flag = "3";
        }
        // 总记录数
        int count = this.noteService.findNoteCount(noteBookId,userId,noteType,noteTitle);
        if(count % page.getPageSize() == 0) {
            // 总页数
            totalPage = count / page.getPageSize();
            // 如果一开始没有数据则count为0,那么totalPage也为0，但是在page类中的分页初始是减1的，所以会造成初始分页为负值，不符合逻辑，所以当totalpage为0时要加1
            if(totalPage == 0) {
                totalPage = 1;
            }
        } else {
            // 总页数
            totalPage = count / page.getPageSize() + 1;
        }
        List<Note> note = this.noteService.findAllNote(noteBookId,userId,noteType,noteTitle,page.getBegin(),page.getPageSize());
        model.addAttribute("note",note);
        model.addAttribute("noteBookTitle",noteBookTitle);
        model.addAttribute("noteBookId",noteBookId);
        model.addAttribute("totalPage",totalPage);
        model.addAttribute("flag",flag);
        model.addAttribute("collect",collect);
        model.addAttribute("collectFlag",collectFlag);
        if(!(NULL).equals(noteType)) {
            model.addAttribute("noteType",noteType);
        }
        if(!(NULL).equals(noteType)) {
            model.addAttribute("noteTitle",noteTitle);
        }
        model.addAttribute("roles",roles);
        model.addAttribute("currentPage",page.getCurrentPage());
        return "note";
    }

    /**
     * 创建笔记
     * @author   Huxudong
     * @date     2019-02-18
     * @param noteBookId     笔记本的id
     * @param noteType       笔记类型
     * @param noteTitle      笔记标题
     * @param noteBody       笔记内容
     * @return               创建成功或者失败后返回的json数据
     */
    @RequestMapping(value = "/createNote.do")
    @ResponseBody
    public String createNote(String noteBookId,String noteType,String noteTitle,String noteBody,HttpSession session) {
        NoteBook noteBook = this.noteBookService.findById(noteBookId);
        String noteBookTitle = noteBook.getNoteBookName();
        if(null == noteTitle || ("").equals(noteTitle)) {
            // 如果笔记标题为空时返回的json标志
            return "NOT";
        }
        // 查询数据库中是否有此笔记标题
        Note note = this.noteService.findByTitle(noteTitle);
        if(null != note) {
            // 如果笔记标题重复时返回的json标志
            return "EXIT";
        }

        User user =(User) session.getAttribute("SESSION");
        String userId = user.getUserId();
        String userName = user.getUserName();
        int row = this.noteService.createNote(noteBookId,userId,userName,noteType,noteTitle,noteBookTitle,noteBody);
        if(row > 0) {
            // 创建笔记成功后返回的json标志
            return "OK";
        }
        // 创建笔记失败后返回的json标志
        return "FAIL";
    }

    /**
     * 根据笔记id查询一条笔记信息
     * @author   Huxudong
     * @date     2019-02-18
     * @param id               笔记的id
     * @return                 查询实体类后返回的json对象
     */
    @RequestMapping(value = "/editNote.do")
    @ResponseBody
    public Note editNote(String id) {
        Note note = this.noteService.findByNoteId(id);
        return note;
    }

    /**
     * 保存修改后的数据并返回json数据信息给前端
     * @author   Huxudong
     * @date     2019-02-18
     * @param noteId            笔记id
     * @param noteType          笔记类型
     * @param noteTitle         笔记标题
     * @param session           用户登录的session对象信息
     * @return                  保存修改后json的数据
     */
    @RequestMapping(value = "/saveNote.do")
    @ResponseBody
    public String saveNote(String noteId,String noteType,String noteTitle,String noteBody,HttpSession session) {
        User user =(User) session.getAttribute("SESSION");
        // 根据笔记标题查询笔记对象
        Note note = this.noteService.findByTitle(noteTitle);
        // 根据笔记的id查询笔记对象
        Note note1 = this.noteService.findByNoteId(noteId);
        // 判断笔记标题是否跟原来标题是够一样，如果一样也可以保存成功
        if(!(noteTitle).equals(note1.getNoteTitle())) {
            if(null != note) {
                // 如果修改后的笔记标题(出去自身的笔记标题相同外)与数据库中其他笔记标题相同就返回的json标志
                return "EXIST";
            }
        }
        int row = this.noteService.saveNote(noteId,noteType,noteTitle,noteBody,user);
        if(row > 0) {
            // 修改成功后返回json标志
            return "OK";
        }
        // 修改失败后返回json标志
        return "FAIL";
    }

    /**
     * 删除一条笔记并返回json数据
     * @author   Huxudong
     * @date     2019-02-18
     * @param id                  笔记的id
     * @return                    删除数据后返回json数据
     */
    @RequestMapping(value = "/recycleNote.do")
    @ResponseBody
    public String recycleNote(String id,HttpSession session) {
        User user = (User)session.getAttribute("SESSION");
        int row = this.noteService.recycleNoteById(id,user);
        if(row > 0) {
            // 删除成功后返回json标志
            return "OK";
        }
        // 删除失败后返回json标志
        return "FAIL";
    }

    /**
     * 删除一条笔记并返回json数据
     * @author   Huxudong
     * @date     2019-02-18
     * @param id                  笔记的id
     * @return                    删除数据后返回json数据
     */
    @RequestMapping(value = "/deleteNote.do")
    @ResponseBody
    public String deleteNote(String id) {

        int row = this.noteService.deleteNote(id);
        if(row > 0) {
            // 删除成功后返回json标志
            return "OK";
        }
        // 删除失败后返回json标志
        return "FAIL";
    }

    /**
     * 根据笔记id查询实体类并返回json对象
     * @author   Huxudong
     * @date     2019-02-18
     * @param id                  笔记id
     * @return                    查询笔记后返回json对象
     */
    @RequestMapping(value = "/lookNote.do")
    @ResponseBody
    public Note lookNote(String id) {
        Note note = this.noteService.findByNoteId(id);
        return note;
    }


    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
}
