/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author lap11916
 */
public class LectureExt {
    private String courseid;
    private String coursename;
    private List<TinyChapter> chapterlist = new ArrayList<>();
    

    public LectureExt(List<String[]> rows) {
        this.courseid = rows.get(0)[0];
        this.coursename = rows.get(0)[1];
        
        HashMap<String, List<String[]>> map = new HashMap<>();
        List<String[]> tempt = new ArrayList<>();
        
        String chapterIDBefore = "";
        String chapterid = "";
        for(String[] row : rows){
            if(chapterIDBefore.isEmpty()){
                chapterIDBefore = row[2];
            }
            chapterid = row[2];
            if(chapterid.equals(chapterIDBefore)){
                tempt.add(row);
            }else{
                map.put(chapterIDBefore, new ArrayList<>(tempt));
                tempt.clear();
                chapterIDBefore = row[2];
                tempt.add(row);
            }
        }
        map.put(chapterIDBefore, new ArrayList<>(tempt));
        
        for(String key : map.keySet()){
            List<String[]> chapterList = map.get(key);
            TinyChapter tinyChapter = new TinyChapter(chapterList);
            chapterlist.add(tinyChapter);
        }
    }
  
    
    
    private class TinyChapter{
        private String id;
        private String name;
        private int chapter_order;
        private List<TinyLecture> lecturelist = new ArrayList<>();

        public TinyChapter(List<String[]> rows) {
            this.id = rows.get(0)[2];
            this.chapter_order = Integer.parseInt(rows.get(0)[3]);
            this.name = rows.get(0)[4];
            
            for(String[] row : rows){
                this.lecturelist.add(new TinyLecture(row));
            }
            
        }
        
    }
    
    private class TinyLecture {

        private String id;
        private String name;
        private String date;
        private String videopath;
        private String docpath;

        public TinyLecture(String[] row) {
            this.id = row[5];
            this.name = row[6];
            this.date = row[7];
            this.videopath = row[8];
            this.docpath = row[9];
        }
    }
    
}
