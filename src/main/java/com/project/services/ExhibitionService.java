package com.project.services;

import com.project.dao.impl.ExhibitionDao;
import com.project.dao.impl.ThemeDao;
import com.project.entities.Exhibition;
import com.project.entities.Theme;
import com.project.web.data.ExhibitionData;
import com.project.web.data.ThemeData;

import java.util.ArrayList;
import java.util.List;

public class ExhibitionService {
    public static List<ExhibitionData> getExhibitionData() {
        List<ExhibitionData> exhibitionDataList = new ArrayList<>();
        ExhibitionDao exhibitionDao = ExhibitionDao.getInstance();
        List<Exhibition> exhibitions = exhibitionDao.getAll();

        for (Exhibition exhibition : exhibitions) {
            ThemeDao themeDao = ThemeDao.getInstance();
            Theme byId = themeDao.getById(exhibition.getIdTheme());
            ThemeData themeData = new ThemeData(byId.getId(), byId.getTheme());

            ExhibitionData exhibitionData = new ExhibitionData(exhibition.getId(), themeData, exhibition.getStartDate(), exhibition.getEndDate(), exhibition.getStartTime(), exhibition.getEndTime(), exhibition.getCost(), exhibition.getStatus());

            exhibitionDataList.add(exhibitionData);

        }
        return exhibitionDataList;

    }

    public static ExhibitionData getExhibitionDataById(int idExhibition) {

        ExhibitionDao exhibitionDao = ExhibitionDao.getInstance();
        Exhibition exhibitionById = exhibitionDao.getById(idExhibition);
        ThemeDao themeDao = ThemeDao.getInstance();

        Theme byId = themeDao.getById(exhibitionById.getIdTheme());
        ThemeData themeData = new ThemeData(byId.getId(), byId.getTheme());

        ExhibitionData exhibitionData = new ExhibitionData(exhibitionById.getId(), themeData, exhibitionById.getStartDate(), exhibitionById.getEndDate(), exhibitionById.getStartTime(), exhibitionById.getEndTime(), exhibitionById.getCost(), exhibitionById.getStatus());

        return exhibitionData;
    }
}
