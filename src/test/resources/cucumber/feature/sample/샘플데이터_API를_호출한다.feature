# language: ko
기능: 샘플데이터 API 호출
  샘플데이터 API를 호출하여 CRUD를 수행한다.

  시나리오 개요: 샘플데이터 조회 API를 호출한다
    먼저 조회 api호출을 위한 "<sampleId>" 있다
    만약 조회 api를 호출하면
    그러면 조회 api 호출결과 <status> 확인한다

    예:
      | sampleId | status |
      | 1        | 200    |
      | 2        | 400    |