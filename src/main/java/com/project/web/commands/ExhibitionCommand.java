package com.project.web.commands;


import com.project.dao.impl.ExhibitionDao;
import com.project.entities.Exhibition;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ExhibitionCommand extends AbstractCommand{

    @Override
    protected String executeGet(HttpServletRequest request, HttpServletResponse response) {

        ExhibitionDao exhibitionDao = ExhibitionDao.getInstance();
        List<Exhibition> exhibitions = exhibitionDao.getAll();
        request.setAttribute("exhibitions", exhibitions);

        return "exhibitions.jsp";
    }

    @Override
    protected String executePost(HttpServletRequest request, HttpServletResponse response) {
        return null;
    }
}
