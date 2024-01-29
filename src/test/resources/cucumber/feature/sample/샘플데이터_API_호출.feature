# language: ko
기능: 샘플데이터 API 호출
  샘플데이터 API를 호출하여 CRUD를 수행한다.

  시나리오 개요: 샘플데이터 조회 API를 호출한다
    먼저 조회 api 호출을 위한 "<sampleId>" 있다
    만약 조회 api를 호출하면
    그러면 조회 api 호출 결과 <status> 확인한다

    예:
      | sampleId | status |
      | 1        | 200    |
      | 2        | 200    |

  시나리오 개요: 샘플데이터 생성 API 호출
    먼저 생성 api 호출을 위한 "<name>" 있다
    만약 생성 api를 호출하면
    그러면 생성 api 호출 결과 <status> 확인한다

    예:
      | name | status |
      | hi   | 200    |


  시나리오 개요: 샘플데이터 이름 수정 API 호출
    먼저 수정 api 호출을 위한 "<id>", "<name>" 있다
    만약 수정 api를 호출하면
    그러면 수정 api 호출 결과 <status> 확인한다

    예:
      |id| name | status |
      |1 |  1  | 200   |
      |2 |  2  | 200   |
      |3 |  3  | 200   |

  시나리오 개요: 샘플데이터 삭제 API 호출
    먼저 삭제 api 호출을 위한 "<id>" 있다
    만약 삭제 api를 호출하면
    그러면 삭제 api 호출 결과 <status> 확인한다

    예:
      |id| status |
      |1 |  200   |
      |2 |  200   |
      |3 |  200   |