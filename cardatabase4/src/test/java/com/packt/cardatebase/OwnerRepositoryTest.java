package com.packt.cardatebase;

import com.packt.cardatebase.domain.Owner;
import com.packt.cardatebase.domain.OwnerRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class OwnerRepositoryTest {
    @Autowired
    private OwnerRepository repository;

    @Test
    void saveOwner(){
        repository.save(new Owner("일", "김")); // 메인에서 쓴 "근수" 예제데이터는 사용불가
        assertThat(
                repository.findByFirstname("일").isPresent()
        ).isTrue();
    }
    @Test
    @DisplayName("테스트#2: Owner 객체가 올바르게 삭제되는지 확인")
    void deleteOwners(){
        repository.save(new Owner("이", "김"));
        repository.deleteAll();
        assertThat(repository.count()).isEqualTo(0);
    }
}