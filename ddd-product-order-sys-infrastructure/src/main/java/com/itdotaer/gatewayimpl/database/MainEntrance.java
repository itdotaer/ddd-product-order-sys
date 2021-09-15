package com.itdotaer.gatewayimpl.database;

import com.itdotaer.gatewayimpl.database.dataobject.ProductInfoDO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.util.StopWatch;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * MainEntrance
 *
 * @author jt_hu
 * @date 2021/9/15
 */
public class MainEntrance {

    public static void main(String[] args) {


        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        AtomicInteger counter = new AtomicInteger();
        for (int i = 0; i < 500; i++) {
            new Thread(() -> {
                SqlSession sqlSession = Mybatis3Utils.getCurrentSqlSession();
                ProductInfoMapper productInfoMapper = sqlSession.getMapper(ProductInfoMapper.class);

                while (counter.get() < 10000) {
                    ProductInfoDO productInfoDO = new ProductInfoDO();
                    productInfoDO.setProductName("测试产品名称");
                    productInfoDO.setActive(true);
                    productInfoDO.setOnline(true);
                    productInfoDO.setStatus(1);
                    productInfoDO.setCreator("jt_hu");
                    productInfoDO.setModifier("jt_hu");

                    productInfoMapper.create(productInfoDO);
                    sqlSession.commit();
                    counter.incrementAndGet();
                }

                Mybatis3Utils.closeCurrentSession();
            }).start();
        }

        stopWatch.stop();
        System.out.println(stopWatch.getTotalTimeMillis());
    }

}
