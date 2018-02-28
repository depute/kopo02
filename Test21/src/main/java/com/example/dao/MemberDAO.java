package com.example.dao;
 
import java.util.List;

import org.springframework.ui.Model;

import com.example.vo.*;
 
public interface MemberDAO {
    
    public List<MemberVO> selectMember() throws Exception;
    public List<Fir> selectFir(int p) throws Exception;
    public int selectcnt() throws Exception;
    public List<re> selectre(int rootid) throws Exception;
    public List<Thi> selectid() throws Exception;
    public void insert(Sec sec) throws Exception;
    public List<Fou> selectview(int id) throws Exception;
    public void updateview(int id) throws Exception;
    public void upd(Sec sec) throws Exception;
    public void del(int id) throws Exception;
    public int selectreid(int rootid) throws Exception;
    public void insertre(Fif fif) throws Exception;
    public void updre(Fif fif) throws Exception;
    public void delre(Thi thi) throws Exception;
    public List<Fif> selectrev(Thi thi) throws Exception;
    public List<Fir> selecttitle(String con) throws Exception;
    public List<Fir> selectcontent(String con) throws Exception;
    public List<Fir> selectwrt(String con) throws Exception;
    public int selectcnttitle(String con) throws Exception;
    public int selectcntcontent(String con) throws Exception;
    public int selectcntwrt(String con) throws Exception;
}