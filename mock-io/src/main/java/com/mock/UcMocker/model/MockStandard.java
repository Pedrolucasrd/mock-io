package com.mock.UcMocker.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MockStandard {
    @Id
    private String mockName;

    @Column(length = 10000)
    private String mockContent;

    @OneToMany
    private List<QueryParam> queryParams;

    private HttpMethod httpMethod;

    private Boolean activityStatus;

    private LocalDateTime createDate;

    private LocalDateTime updateDate;

    public MockStandard(String mockName, String mockContent, Map<String, String> queryParams) {
        this.mockName = mockName;
        this.mockContent = mockContent;
        this.activityStatus = true;
        this.createDate = LocalDateTime.now();
        this.updateDate = LocalDateTime.now();
    }
}
