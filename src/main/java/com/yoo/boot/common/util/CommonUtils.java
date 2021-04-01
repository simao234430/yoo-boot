package com.yoo.boot.common.util;

import com.yoo.boot.common.constant.CommonConstant;
import com.yoo.boot.common.constant.DataBaseConstant;
import com.yoo.boot.common.exception.YooBootException;
import com.yoo.boot.common.system.util.YooDataAutorUtils;
import lombok.extern.slf4j.Slf4j;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.sql.DataSource;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
public class CommonUtils {

   //中文正则
    private static Pattern ZHONGWEN_PATTERN = Pattern.compile("[\u4e00-\u9fa5]");


    /** 当前系统数据库类型 */
    private static String DB_TYPE = "";
    public static String getDatabaseType() {
        if(oConvertUtils.isNotEmpty(DB_TYPE)){
            return DB_TYPE;
        }
        DataSource dataSource = SpringContextUtils.getApplicationContext().getBean(DataSource.class);
        try {
            return getDatabaseTypeByDataSource(dataSource);
        } catch (SQLException e) {
            //e.printStackTrace();
            log.warn(e.getMessage());
            return "";
        }
    }

    /**
     * 获取数据库类型
     * @param dataSource
     * @return
     * @throws SQLException
     */
    private static String getDatabaseTypeByDataSource(DataSource dataSource) throws SQLException{
        if("".equals(DB_TYPE)) {
            Connection connection = dataSource.getConnection();
            try {
                DatabaseMetaData md = connection.getMetaData();
                String dbType = md.getDatabaseProductName().toLowerCase();
                if(dbType.indexOf("mysql")>=0) {
                    DB_TYPE = DataBaseConstant.DB_TYPE_MYSQL;
                }else if(dbType.indexOf("oracle")>=0 ||dbType.indexOf("dm")>=0) {
                    DB_TYPE = DataBaseConstant.DB_TYPE_ORACLE;
                }else if(dbType.indexOf("sqlserver")>=0||dbType.indexOf("sql server")>=0) {
                    DB_TYPE = DataBaseConstant.DB_TYPE_SQLSERVER;
                }else if(dbType.indexOf("postgresql")>=0) {
                    DB_TYPE = DataBaseConstant.DB_TYPE_POSTGRESQL;
                }else {
                    throw new YooBootException("数据库类型:["+dbType+"]不识别!");
                }
            } catch (Exception e) {
                log.error(e.getMessage(), e);
            }finally {
                connection.close();
            }
        }
        return DB_TYPE;

    }
}