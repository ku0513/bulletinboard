package com.example.bulletinboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.List;

@Controller
public class BulletinBoardController {

    private BulletinBoardRepository repos;

    @Autowired
    public BulletinBoardController(BulletinBoardRepository repos) {
        this.repos = repos;
    }

    @GetMapping("/")
    public ModelAndView list() {
        ModelAndView mav = new ModelAndView();
        List<BulletinBoard> list = repos.findAll();
        mav.setViewName("bulletinBoard/list");
        mav.addObject("data", list);
        return mav;
    }

    @GetMapping("/add")
    ModelAndView add() {
        ModelAndView mav = new ModelAndView();
        BulletinBoard data = new BulletinBoard();
        mav.addObject("formModel", data);
        mav.setViewName("bulletinBoard/new");
        return mav;
    }

    @GetMapping("/edit")
    ModelAndView edit(@RequestParam int id) {
        ModelAndView mav = new ModelAndView();
        BulletinBoard data = repos.findById(id);
        mav.addObject("formModel", data);
        mav.setViewName("bulletinBoard/new");
        return mav;
    }

    @PostMapping("/create")
    @Transactional(readOnly=false)
    public ModelAndView save(
            @ModelAttribute("formModel") BulletinBoard bulletinBoard) {
        bulletinBoard.setCreateDate(new Date());
        repos.saveAndFlush(bulletinBoard);
        return new ModelAndView("redirect:/");
    }

    @PostMapping("/delete")
    @Transactional(readOnly=false)
    public ModelAndView delete(@RequestParam int id) {
        repos.deleteById(id);
        return new ModelAndView("redirect:/");
    }

    @GetMapping("/show")
    ModelAndView show(@RequestParam int id) {
        ModelAndView mav = new ModelAndView();
        BulletinBoard data = repos.findById(id);
        mav.addObject("formModel", data);
        mav.setViewName("bulletinBoard/show");
        return mav;
    }

    @PostConstruct
    public void init() {
        BulletinBoard bbs1 = new BulletinBoard();
        bbs1.setCreateDate(new Date());
        bbs1.setTitle("帰社日について");
        bbs1.setContent("記者日は以下の通りに決定しました。2020/07/08");
        bbs1.setCreateUser("島根");
        repos.saveAndFlush(bbs1);
    }
}
