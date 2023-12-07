package com.example.demo.repository;

import com.example.demo.model.jobs.JobRootJoinItem;
import com.example.demo.model.jobs.JobTemp1Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JobRootJoinRepository extends JpaRepository<JobRootJoinItem, String> {
    List<JobRootJoinItem> findBySub1List_NameContaining(String keyword);
    List<JobRootJoinItem> findBySub1List_NameContainingOrSub1List_NameContaining(String keyword, String keyword2);
    List<JobRootJoinItem> findBySub1List_CodeIn(List<String> codes);

    @Query(value = "SELECT DISTINCT root FROM JobRootJoinItem root " +
            "LEFT JOIN FETCH root.sub1List sub1 " +
//            "LEFT JOIN FETCH sub1.sub2List sub2 " +
//            "LEFT JOIN FETCH sub2.sub3List sub3 " +
//            "LEFT JOIN FETCH sub3.sub3List sub4 " +
            "WHERE sub1.code = :sub1Code"
            //, nativeQuery = true
    )
    List<JobRootJoinItem> findBySub1Code(@Param("sub1Code") String sub1Code);


    @Query(value = "select " +
            "        root.code AS root_code  " +
            "        , root.name AS root_name  " +
            "        , sub1.code AS sub_code " +
            "        , sub1.name AS sub_name " +
            "        from         jobs_root root     " +
            "    inner join jobs_sub1 sub1                         on root.code=sub1.root_code     " +
            "    where " +
            "        sub1.code =   :sub1Code "
            , nativeQuery = true
    )
    List<JobTemp1Item> findBySub1Code2(@Param("sub1Code") String sub1Code);
}
