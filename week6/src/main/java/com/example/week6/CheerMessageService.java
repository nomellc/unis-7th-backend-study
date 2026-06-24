package com.example.week6;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class CheerMessageService {

    private final CheerMessageRepository cheerMessageRepository;

    //컨트롤러에서 받은 새 응원 메시지(dto 형태)의 작성자 이름,내용을 저장
    @Transactional
    public void create(CheerMessageDTO cheerMessageDTO) {
        //받은 dto를 entity로 변환해 저장
        CheerMessage entity = new CheerMessage(cheerMessageDTO.writer(),cheerMessageDTO.content());
        cheerMessageRepository.save(entity);
    }

    //한 페이지에 10개, 최신순 정렬
    /*
    Pageable은 인터페이스이며, PageRequest.of(...)를 통해 생성된 구현체 내부에는
    "데이터를 어디서부터 얼마나, 어떤 순서로 가져올 것인가"에 대한 메타데이터가 담겨 있습니다.
    주요 포함 정보:
    pageNumber: 조회할 페이지 번호 (0부터 시작)
    pageSize: 한 페이지에 담을 데이터 개수 (여기서는 10)
    offset: 해당 페이지의 시작 지점 (계산식: pageNumber * pageSize)
    sort: 정렬 조건 (여기서는 id: DESC)
     */
    public Page<CheerMessageDTO> getList(int page) {
        Pageable pageable= PageRequest.of(page,10, Sort.by("createDate").descending());
        Page<CheerMessage> entityPage= cheerMessageRepository.findAll(pageable);//JPA가 정렬 조건과 페이징 정보를 결합해 SQL 쿼리 생성. 엔티티 반환받음

        //service에서 entity를 DTO로 변환해 반환(엔티티가 밖으로 못 나가도록)
        return entityPage.map(m->new CheerMessageDTO(
           m.getId(),
           m.getWriter(),
           m.getContent()
        ));

    }








}
