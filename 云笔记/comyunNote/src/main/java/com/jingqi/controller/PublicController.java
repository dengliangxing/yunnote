package com.jingqi.controller;
import com.jingqi.domain.Note;
import com.jingqi.domain.Public;
import com.jingqi.domain.User;
import com.jingqi.service.NoteService;
import com.jingqi.service.PublicService;
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
 * 公开笔记controller层
 * @author Huxudong
 * @createTime 2019-03-30 19:52:49
 **/
@Controller
public class PublicController {
    @Autowired
    private PublicService publicService;
    @Autowired
    private NoteService noteService;
    /**
     * 首页页面显示
     * @author Huxudong
     * @date       2019-02-10
     * @return     首页页面
     **/
    @RequestMapping(value = "/head.do")
    public String head(Model model, Page page, HttpServletRequest request, HttpSession session) {
        // 总页数
        int totalPage ;
        // 总记录数
        int count = this.publicService.findByCount();
        String roles = request.getParameter("roles");
        User user = (User) session.getAttribute("SESSION");
        String userId = user.getUserId();
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

        List<Public> publics = this.publicService.findAllPublic(page.getBegin(),page.getPageSize());
        model.addAttribute("publics",publics);
        model.addAttribute("roles",roles);
        model.addAttribute("totalPage",totalPage);
        model.addAttribute("currentPage",page.getCurrentPage());
        model.addAttribute("userId",userId);
        return "head";
    }

    /**
     * 公开笔记
     * @author Huxudong
     * @date  2019-03-30 19:25:41
     * @param id                  笔记id
     * @return                    返回笔记的json对象
     **/
    @RequestMapping(value = "/publicNote.do")
    @ResponseBody
    public String publicNote(String id,HttpSession session) {
        Note note = this.noteService.findByNoteId(id);
        Public pub = this.publicService.findByPublicNoteId(note.getNoteId());
        User user = (User) session.getAttribute("SESSION");
        if(null != pub) {
            return "REPEAT";
        }
        int row = this.publicService.publicNote(note,user);
        if(row > 0) {
            return "OK";
        }
        return "FAIL";
    }

    /**
     * 查询公开的笔记
     * @author Huxudong
     * @createTime 2019-03-30 23:25:40
     * @param id             笔记id
     * @return com.jingqi.domain.Public     笔记的信息类
     **/
    @RequestMapping(value = "/lookPublicNote.do")
    @ResponseBody
    public Public lookPublicNote(String id) {
        Public pub = this.publicService.findByPublicNote(id);
        return pub;
    }

    /**
     * 删除成功或失败返回json的数据
     * @author Huxudong
     * @createTime 2019-03-30 23:56:32
     * @param id                      笔记id
     * @return java.lang.String       返回json数据
     **/
    @RequestMapping(value = "/deletePublicNote.do")
    @ResponseBody
    public String deletePublicNote(String id) {
        int row = this.publicService.deletePublicNote(id);
        if(row > 0) {
            return "OK";
        }
        return "FAIL";
    }

    /**
     * 删除成功或失败返回json的数据
     * @author Huxudong
     * @createTime 2019-03-30 23:56:32
     * @param id                      笔记id
     * @return java.lang.String       返回json数据
     **/
    @RequestMapping(value = "/CancelNote.do")
    @ResponseBody
    public String  CancelNote(String id) {
        Note note = this.noteService.findByNoteId(id);
        Public pub = this.publicService.findByPublicNoteId(note.getNoteId());
        if(null == pub) {
            return "NONE";
        }
        int row = this.publicService.deleteByNoteId(note.getNoteId());
        if(row > 0) {
            return "OK";
        }
        return "FAIL";
    }

}
