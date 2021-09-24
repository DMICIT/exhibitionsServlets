package com.project.web.commands;


import com.project.dao.impl.ExhibitionDao;
import com.project.dao.impl.ThemeDao;
import com.project.entities.Exhibition;
import com.project.entities.Theme;
import com.project.web.data.ExhibitionData;
import com.project.web.data.ThemeData;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class ExhibitionCommand extends AbstractCommand{

    @Override
    protected String executeGet(HttpServletRequest request, HttpServletResponse response) {

        List<ExhibitionData> exhibitionDataList = new ArrayList<>();
        ExhibitionDao exhibitionDao = ExhibitionDao.getInstance();
        List<Exhibition> exhibitions = exhibitionDao.getAll();

        for (Exhibition exhibition: exhibitions) {
            ThemeDao themeDao = ThemeDao.getInstance();
            Theme byId = themeDao.getById(exhibition.getIdTheme());
            ThemeData themeData = new ThemeData(byId.getId(), byId.getTheme());

            ExhibitionData exhibitionData = new ExhibitionData(exhibition.getId(), themeData, exhibition.getStartDate(),exhibition.getEndDate(),exhibition.getStartTime(), exhibition.getEndTime(),exhibition.getCost(), exhibition.getStatus());

            exhibitionDataList.add(exhibitionData);

        }



        request.setAttribute("exhibitions", exhibitionDataList);



        return "exhibitions.jsp";
    }

    @Override
    protected String executePost(HttpServletRequest request, HttpServletResponse response) {
        return null;
    }
}
