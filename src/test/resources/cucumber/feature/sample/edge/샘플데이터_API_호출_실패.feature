# language: ko
기능: 샘플데이터 API 호출 edge
  샘플데이터 API를 호출 실패 케이스 테스트

  시나리오 개요: 샘플데이터 조회 API 호출 실패 케이스
    먼저 조회 실패 api 호출을 위한 "<sampleId>" 있다
    만약 조회 실패 api를 호출하면
    그러면 조회 실패 api 호출 결과 <status> 확인한다

    예:
      | sampleId | status |
      | 105      | 404    |
      | 245      | 404    |
      | 500      | 404    |

  시나리오 개요: 샘플데이터 생성 API 호출 실패 케이스
    먼저 생성 실패 api 호출을 위한 "<name>" 있다
    만약 생성 실패 api를 호출하면
    그러면 생성 실패 api 호출 결과 <status> 확인한다

    예:
      | name | status |
      |      | 404    |

  시나리오 개요: 샘플데이터 이름 수정 API 호출 실패 케이스
    먼저 수정 실패 api 호출을 위한 "<id>", "<name>" 있다
    만약 수정 실패 api를 호출하면
    그러면 수정 실패 api 호출 결과 <status> 확인한다

    예:
      |id| name | status |
      |205 |  205  | 404   |
      |fail |  fail  | 400   |
      |4 |       | 400   |

  시나리오 개요: 샘플데이터 삭제 API 호출 실패 케이스
    먼저 삭제 실패 api 호출을 위한 "<id>" 있다
    만약 삭제 실패 api를 호출하면
    그러면 삭제 실패 api 호출 결과 <status> 확인한다

    예:
      |id| status |
      |fail |  400  |
      |     |  404 |