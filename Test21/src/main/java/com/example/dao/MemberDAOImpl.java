package com.example.dao;

import java.util.List;

import javax.inject.Inject;
 
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import com.example.vo.*;
 
@Repository
public class MemberDAOImpl implements MemberDAO {
 
    @Inject
    private SqlSession sqlSession;
    
    private static final String Namespace = "com.example.mapper.memberMapper";
    
    @Override
    public List<MemberVO> selectMember() throws Exception {
 
        return sqlSession.selectList(Namespace+".selectMember");
    }
    @Override
    public List<Fir> selectFir(int p) throws Exception {
 
        return sqlSession.selectList(Namespace+".selectFir",p);
    }
    @Override
    public int selectcnt() throws Exception {
 
        return sqlSession.selectOne(Namespace+".selectcnt");
    }
    @Override
    public List<re> selectre(int rootid) throws Exception {
 
        return sqlSession.selectList(Namespace+".selectre",rootid);
    }
    @Override
    public List<Thi> selectid() throws Exception {
 
        return sqlSession.selectList(Namespace+".selectid");
    }
    public void insert(Sec sec) throws Exception{
    	sqlSession.insert(Namespace+".insert",sec);
    }
    @Override
    public List<Fou> selectview(int id) throws Exception {
 
        return sqlSession.selectList(Namespace+".selectview",id);
    }
    public void updateview(int id) throws Exception{
    	sqlSession.update(Namespace+".updateview",id);
    }
    public void upd(Sec sec) throws Exception{
    	sqlSession.update(Namespace+".upd",sec);
    }
    public void del(int id) throws Exception{
    	sqlSession.delete(Namespace+".del",id);
    }
    @Override
    public int selectreid(int rootid) throws Exception {
 
        return sqlSession.selectOne(Namespace+".selectreid",rootid);
    }
    public void insertre(Fif fif) throws Exception{
    	sqlSession.insert(Namespace+".insertre",fif);
    }
    public void updre(Fif fif) throws Exception{
    	sqlSession.update(Namespace+".updre",fif);
    }
    public void delre(Thi thi) throws Exception{
    	sqlSession.delete(Namespace+".delre",thi);
    }
    @Override
    public List<Fif> selectrev(Thi thi) throws Exception {
 
        return sqlSession.selectList(Namespace+".selectrev",thi);
    }
    @Override
    public List<Fir> selecttitle(String con) throws Exception {
 
        return sqlSession.selectList(Namespace+".selecttitle",con);
    }
    @Override
    public List<Fir> selectcontent(String con) throws Exception {
 
        return sqlSession.selectList(Namespace+".selectcontent",con);
    }
    @Override
    public List<Fir> selectwrt(String con) throws Exception {
 
        return sqlSession.selectList(Namespace+".selectwrt",con);
    }
    @Override
    public int selectcnttitle(String con) throws Exception {
 
        return sqlSession.selectOne(Namespace+".selectcnttitle",con);
    }
    @Override
    public int selectcntcontent(String con) throws Exception {
 
        return sqlSession.selectOne(Namespace+".selectcntcontent",con);
    }
    @Override
    public int selectcntwrt(String con) throws Exception {
 
        return sqlSession.selectOne(Namespace+".selectcntwrt",con);
    }
}