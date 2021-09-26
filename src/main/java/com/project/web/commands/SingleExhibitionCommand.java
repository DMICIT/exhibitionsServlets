package com.project.web.commands;

import com.project.dao.impl.ExhibitionDao;
import com.project.entities.Exhibition;
import com.project.services.ExhibitionService;
import com.project.web.data.ExhibitionData;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SingleExhibitionCommand implements Command{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        int idExhibition = Integer.parseInt(request.getParameter("id"));

        ExhibitionData exhibitionData = ExhibitionService.getExhibitionDataById(idExhibition);
        request.setAttribute("exhibition", exhibitionData);

        return "exhibition.jsp";
    }
}
