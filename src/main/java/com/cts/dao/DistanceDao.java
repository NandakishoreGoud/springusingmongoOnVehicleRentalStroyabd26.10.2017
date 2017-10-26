package com.cts.dao;

;
import com.cts.pojo.CityDistances;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;


@Repository
public class DistanceDao implements DaoMethods{


    @Autowired
    MongoTemplate template;

    public Integer getDistanceByCityName(String city){
        Query searchByCityName=new Query(Criteria.where("city").is(city));
        CityDistances cityDistances =template.findOne(searchByCityName,CityDistances.class);
        Integer distance= cityDistances.getDistance();
        return distance;
    }
}
