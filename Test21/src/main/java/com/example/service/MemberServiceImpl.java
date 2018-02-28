package com.example.service;

import java.util.List;

import javax.inject.Inject;
 
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.example.dao.MemberDAO;
import com.example.vo.*;
 
@Service
public class MemberServiceImpl implements MemberService {
 
    @Inject
    private MemberDAO dao;
    
    @Override
    public List<MemberVO> selectMember() throws Exception {
 
        return dao.selectMember();
    }
    @Override
    public List<Fir> selectFir(int p) throws Exception {
 
        return dao.selectFir(p);
    }
    @Override
    public int selectcnt() throws Exception {
 
        return dao.selectcnt();
    }
    @Override
    public List<re> selectre(int rootid) throws Exception {
 
        return dao.selectre(rootid);
    }
    @Override
    public List<Thi> selectid() throws Exception {
 
        return dao.selectid();
    }
    public void insert(Sec sec) throws Exception{
    	dao.insert(sec);
    }
    @Override
    public List<Fou> selectview(int id) throws Exception {
 
        return dao.selectview(id);
    }
    public void updateview(int id) throws Exception{
    	dao.updateview(id);
    }
    public void upd(Sec sec) throws Exception{
    	dao.upd(sec);
    }
    public void del(int id) throws Exception{
    	dao.del(id);
    }
    @Override
    public int selectreid(int rootid) throws Exception {
 
        return dao.selectreid(rootid);
    }
    public void insertre(Fif fif) throws Exception{
    	dao.insertre(fif);
    }
    public void updre(Fif fif) throws Exception{
    	dao.updre(fif);
    }
    public void delre(Thi thi) throws Exception{
    	dao.delre(thi);
    }
    @Override
    public List<Fif> selectrev(Thi thi) throws Exception {
 
        return dao.selectrev(thi);
    }
    @Override
    public List<Fir> selecttitle(String con) throws Exception {
 
        return dao.selecttitle(con);
    }
    @Override
    public List<Fir> selectcontent(String con) throws Exception {
 
        return dao.selectcontent(con);
    }
    @Override
    public List<Fir> selectwrt(String con) throws Exception {
 
        return dao.selectwrt(con);
    }
    @Override
    public int selectcnttitle(String con) throws Exception {
 
        return dao.selectcnttitle(con);
    }
    @Override
    public int selectcntcontent(String con) throws Exception {
 
        return dao.selectcntcontent(con);
    }
    @Override
    public int selectcntwrt(String con) throws Exception {
 
        return dao.selectcntwrt(con);
    }
 
}