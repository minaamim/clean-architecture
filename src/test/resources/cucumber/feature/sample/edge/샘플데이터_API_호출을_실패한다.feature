# language: ko
기능: 샘플데이터 API 호출 edge
  샘플데이터 API를 호출에 실패한다

  # 실패케이스에 대해서만 테스트한다
  시나리오 개요: 샘플데이터 조회 API를 호출한다
    먼저 실패 조회 api호출을 위한 "<sampleId>" 있다
    만약 실패 조회 api를 호출하면
    그러면 실패 조회 api 호출결과 <status> 확인한다

    예:
      | sampleId | status |
      | 2        | 400    |
      | 999      | 500    |