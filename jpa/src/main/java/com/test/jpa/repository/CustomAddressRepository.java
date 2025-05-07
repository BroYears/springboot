package com.test.jpa.repository;

import com.querydsl.core.Tuple;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.test.jpa.dto.AddressDTO;
import com.test.jpa.entity.Address;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.expression.spel.ast.Projection;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.test.jpa.entity.QAddress.address1;

@Repository
@RequiredArgsConstructor
public class CustomAddressRepository {

    private final JPAQueryFactory factory;
    private final AddressRepository addressRepository;


    public List<Address> findAll() {


        /*

            - selectFrom: 해당 엔티티에서 모든 컬럼 조회
                - select a from AddRess as a
                
            - fetch(): 리스트 조회, 결과가 없으면 빈 리스트 반환
            - fetchOne(): 단일 조회, 레코드(엔티티) 1개 반환, 결과가 다중 레코드면 Exception
            - fetchFirst(): 단일 조회, 레코드(엔티티) 1개 반환, 결과가 다중 레코드면 첫 번째 레코드 반환
            - fetchResult(): 페이징 정보 포함
            - fetchCount(): 카운트 반환

        */



        return  factory
                    .selectFrom(address1) //ResultSet
                    .fetch();
    }


    public Address findByName(String name) {

        //레코드 1개 반환
        //- 조건절
        //- select * from tblAddress where name = '강아지'

        return factory
                .selectFrom(address1)
                .where(address1.name.eq(name))
                .fetchOne();
    }

    public List<String> findName() {

        //모든 컬럼: .selectFrom() = select * from
        //특정 컬럼: select() = select 컬럼 from

        return factory
                .select(address1.name)  //select *
                .from(address1)         //from tblAddress
                .fetch();               //mapping
    }

    public List<Tuple> findNameAndAgeAndAddress() {

        //Type mismatch

        return factory
                .select(address1.name, address1.age, address1.address)
                .from(address1)
                .fetch()
                ;

    }

    public List<AddressDTO> findNameAndAgeAndAddress2() {

        //JPA > select 결과 > Entity
        //엔티티 > (매핑) > DTO

        //1. .select(컬럼) > .select(address1.name)
        //2. .select(컬럼, 컬럼) > .select(address1.name, address1.age) list<Tuple>
        //3. .select(컬럼, 컬럼) > .select(address1.name, address1.age) list<DTO>



        return factory
                .select(Projections.constructor(AddressDTO.class, address1.name, address1.age, address1.address))
                .from(address1)
                .fetch();

    }
}












