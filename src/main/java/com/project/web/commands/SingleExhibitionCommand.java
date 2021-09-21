package com.project.web.commands;

import com.project.dao.impl.ExhibitionDao;
import com.project.entities.Exhibition;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SingleExhibitionCommand implements Command{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        int idExhibition = Integer.parseInt(request.getParameter("id"));
        ExhibitionDao exhibitionDao = ExhibitionDao.getInstance();
        Exhibition byId = exhibitionDao.getById(idExhibition);
        request.setAttribute("exhibition", byId);
        return "exhibition.jsp";
    }
}
