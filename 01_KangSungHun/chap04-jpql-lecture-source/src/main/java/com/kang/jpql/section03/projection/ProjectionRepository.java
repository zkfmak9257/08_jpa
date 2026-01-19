package com.kang.jpql.section03.projection;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProjectionRepository {

  @PersistenceContext
  private EntityManager manager;

  /* 엔티티 프로젝션 */
	public List<Menu> singleEntityProjection() {

        // SELECT 절에 엔티티 이름 (또는 별칭) 작성
	  String jpql = "SELECT m FROM Section03Menu m";
	  List<Menu> menuList 
	    = manager.createQuery(jpql, Menu.class).getResultList();

	  return menuList;
	}
    public List<MenuInfo> embeddedTypeProjection() {

        // 메뉴명, 메뉴 가격을 조회
        String jpql = "SELECT m.menuInfo FROM EmbeddedMenu m";

        // 조회 결과를 MenuInfo 타입으로 저장, 영속성 컨텍스트에서 관리 x(엔티티가 아니어서)
        List<MenuInfo> resultMenuInfo
                = manager.createQuery(jpql, MenuInfo.class).getResultList();

        return resultMenuInfo;
    }

    /* 스칼라 타입 프로젝션 */

    public List<String> scalarTypeProjectionByTypedQuery() {
        String jpql = "SELECT c.categoryName FROM Section03Category c";

        List<String> resultList = manager.createQuery(jpql, String.class).getResultList();

        return resultList;

    }

    public List<Object[]> scalarTypeProjectionByQuery() {
        String jpql
                = "SELECT c.categoryCode, c.categoryName FROM Section03Category c";
        List<Object[]> resultList = manager.createQuery(jpql).getResultList();

        return resultList;
    }

    public List<CategoryInfo> newCommandProjection() {
        String jpql
                = "SELECT new com.kang.jpql.section03.projection.CategoryInfo"
                + "(c.categoryCode, c.categoryName) FROM Section03Category c";
        List<CategoryInfo> resultList
                = manager.createQuery(jpql, CategoryInfo.class).getResultList();

        return resultList;
    }


}

