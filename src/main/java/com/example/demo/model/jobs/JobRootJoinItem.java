package com.example.demo.model.jobs;

import com.example.demo.model.jobs.table.JobsRoot;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * 대분류 item
 */
@Getter
@Setter
@Entity
@Table(name = "JOBS_ROOT")
public class JobRootJoinItem extends JobsRoot {
    /**
     * 대분류에 포함된 중분류
     * fk 연결된 model 경우 cascade 설정 해줘야 함.
     *      CascadeType.ALL은 JPA에서 부모 엔터티에 대한 변경이 자식 엔터티에 영향을 미치도록 하는 옵션입니다.
     *      이 옵션을 사용하면 부모 엔터티에 대한 변경(추가, 수정, 삭제 등)이 자식 엔터티에도 전파되어 해당 변경이 자식 엔터티에 자동으로 적용됩니다.
      */
    @OneToMany(mappedBy = "root", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<JobSub1JoinItem> sub1List;

    public JobRootJoinItem() {
        // 기본 생성자
    }
}
