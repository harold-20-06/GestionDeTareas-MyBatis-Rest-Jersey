package com.spectrum.GestionDeTareas.utilities;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;

public class BaseDatos {

    private static final String MYBATIS_CONFIG_FILE = "mybatis-config.xml";

    public static SqlSession openSession() {
        SqlSessionFactory sqlSessionFactory = null;
        SqlSession sqlSession = null;

        try {
            String resource = MYBATIS_CONFIG_FILE;
            Reader reader = Resources.getResourceAsReader(resource);
            // Instanciación del Factory
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            // Crear el Objeto Session
            sqlSession = sqlSessionFactory.openSession();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return sqlSession;
    }

}
