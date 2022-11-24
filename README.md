# -project-Fake_Escape

# Fake_Escape
2학년 2학기 '자바어플리케이션' 자유주제 기말 프로젝트

# <소개>
- Java의 이미지, 음악, 마우스, 키보드 이벤트 처리를 활용한 리듬게임
- 모티브 Melody's Escape https://store.steampowered.com/app/270210/Melodys_Escape/
- 음악에 맞춰서 생성된 음표(방향키)먹으면 캐릭터의 색상이 변하고, 리듬에 맞춰 모션(방향키) 눌러 장애물을 통과하는 리듬 게임
- 캐릭터의 X축은 고정되어 있고 배경과 필드와 장애물이 움직이는 형식
  
  ## 음표, 모션(방향키)
  <img src="./readme_media/leftKey.png"> <img src="./readme_media/downKey.png"> <img src="./readme_media/rightKey.png"> <img src="./readme_media/upKey.png">
  - 방향키는 총 4종
  
  <img src="./readme_media/leftKey_effect.gif" width="7%" height="7%"> <img src="./readme_media/downKey_effect.gif" width="10%" height="10%"> <img src="./readme_media/rightKey_effect.gif" width="10%" height="10%"> <img src="./readme_media/upKey_effect.gif" width="10%" height="10%">
  - 옳은 방향키를 입력시 캐릭터의 색상이 변하고 방향키가 확산하면서 사라지는 효과를 구현.
  - 15개의 이미지의 투명도와 크기를 조정하면서 이미지 출력
  
  <img src="./readme_media/motion_KickKey_1.png"  width="10%" height="10%"> <img src="./readme_media/motion_slideKey_1.png"> <img src="./readme_media/motion_flyKey_1.png"> <img src="./readme_media/motion_KickKey_1.png"> 

  <img src="./readme_media/motion_KickKey_2.png"> <img src="./readme_media/motion_slideKey_2.png"> <img src="./readme_media/motion_flyKey_2.png"> <img src="./readme_media/motion_KickKey_2.png"> 
  - 모션키는 총 4종
  - 아직 눌러지지 않는 모션키는 바닥에서 빛이 나는 효과로 표현.
  
  ## 모션(캐릭터)
  - 포토샵과 애니메이트를 활용하여 작업하였다.
  - 모션마다 40개의 이미지로 구성, 모션마다 캐릭터의 출력 위치를 조정하여 움직임을 구현.
    ### 달리기 모션(기본 모션)
    <img src="./readme_media/player_run.gif" width="20%" height="20%">
    
    ### 발차기 모션
    <img src="./readme_media/player_kick.gif" width="20%" height="20%">
    
    ### 점프 모션
    <img src="./readme_media/player_jump.gif" width="20%" height="20%">
    
    ### 슬라이딩 모션
    <img src="./readme_media/player_slide.gif" width="20%" height="20%">
    
    ### 넘어지는 모션
    <img src="./readme_media/player_falldown.gif" width="20%" height="20%">
    
    ### 플라잉 모션
    <img src="./readme_media/player_fly.gif" width="25%" height="25%"> 
    
    - 시각적인 잔상효과를 추가
  ## 배경, 장애물
  - 캐릭터의 X축은 고정되어 있고 배경과 필드와 장애물이 움직이는 형식
    ### 무한 반복 배경, 필드
    <img src="./readme_media/background.gif" width="20%" height="20%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="./readme_media/field.png" width="25%" height="25%">
    
    ### 공중 장애물 
    <img src="./readme_media/obstruction.png" width="10%" height="10%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="./readme_media/player_slide2.gif"  width="25%" height="25%">
    - 슬라이딩 성공시 장애물 색상 변경
    ### 벽, 벽이 깨지는 효과(발차기)
    <img src="./readme_media/wall.png">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="./readme_media/wall_breaking.gif">
    
  ## 어려웠던점
  - 포토샵, 애니메이트 학습
  - 낮은 성능의 개발환경
  
## <개발환경>
- IDE : Eclipse
- Design : Adobe Photoshop, Adobe Animate
- Hardware : intel Pentium(laptop 4core 1.8Ghz), RAM 4GB

## <개발기간>
2017년 11월~12월(1달)

## <실행영상>

