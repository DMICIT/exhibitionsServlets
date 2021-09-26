package com.project.web.commands;



import com.project.services.ExhibitionService;
import com.project.web.data.ExhibitionData;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;

public class ExhibitionCommand extends AbstractCommand{

    @Override
    protected String executeGet(HttpServletRequest request, HttpServletResponse response) {

        List<ExhibitionData> exhibitionData = ExhibitionService.getExhibitionData();
        request.setAttribute("exhibitions", exhibitionData);

        return "exhibitions.jsp";
    }

    @Override
    protected String executePost(HttpServletRequest request, HttpServletResponse response) {
        return null;
    }
}
