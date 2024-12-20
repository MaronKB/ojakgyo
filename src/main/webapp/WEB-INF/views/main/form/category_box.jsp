<%@ page contentType="text/html;charset=UTF-8" %>
<div id="category-box-container" class="main-box-container" data-target="category-box-container">
    <div id="category-box" class="main-box">
        <header class="location-box-header main-box-header">
            <h3>내 위치</h3>
            <a data-target="category-box-container" onclick="toggleBox(this)"><i class="fa-solid fa-times"></i></a>
        </header>
        <div class="category-box-body main-box-body">
            <div class="categories">
                <input type="checkbox" name="category" id="목욕탕" value="목욕탕">
                <label for="목욕탕">목욕탕</label>
                <input type="checkbox" name="category" id="숙박" value="숙박">
                <label for="숙박">숙박</label>
                <input type="checkbox" name="category" id="쇼핑" value="쇼핑">
                <label for="쇼핑">쇼핑</label>
                <input type="checkbox" name="category" id="미용실" value="미용실">
                <label for="미용실">미용실</label>
                <input type="checkbox" name="category" id="대형마트" value="대형마트">
                <label for="대형마트">대형마트</label>
                <input type="checkbox" name="category" id="공원" value="공원">
                <label for="공원">공원</label>
                <input type="checkbox" name="category" id="커피" value="커피">
                <label for="커피">커피</label>
                <input type="checkbox" name="category" id="레저" value="레저">
                <label for="레저">레저</label>
                <input type="checkbox" name="category" id="호텔" value="호텔">
                <label for="호텔">호텔</label>
                <input type="checkbox" name="category" id="마트" value="마트">
                <label for="마트">마트</label>
                <hr>
                <input type="checkbox" name="category" id="TV맛집" value="TV맛집">
                <label for="TV맛집">TV맛집</label>
                <input type="checkbox" name="category" id="카페" value="카페">
                <label for="카페">카페</label>
                <input type="checkbox" name="category" id="한식" value="한식">
                <label for="한식">한식</label>
                <input type="checkbox" name="category" id="중식" value="중식">
                <label for="중식">중식</label>
                <input type="checkbox" name="category" id="일식" value="일식">
                <label for="일식">일식</label>
                <input type="checkbox" name="category" id="레스토랑" value="패밀리레스토랑">
                <label for="레스토랑">레스토랑</label>
                <input type="checkbox" name="category" id="전문음식점" value="전문음식점">
                <label for="전문음식점">전문점</label>
                <input type="checkbox" name="category" id="피자" value="피자">
                <label for="피자">피자</label>
                <input type="checkbox" name="category" id="치킨" value="치킨">
                <label for="치킨">치킨</label>
                <input type="checkbox" name="category" id="디저트" value="디저트">
                <label for="디저트">디저트</label>
                <input type="checkbox" name="category" id="제과점" value="제과점">
                <label for="제과점">빵집</label>
                <input type="checkbox" name="category" id="패스트푸드" value="패스트푸드">
                <label for="패스트푸드">패스트푸드</label>
                <hr>
                <input type="checkbox" name="category" id="교통" value="교통">
                <label for="교통">교통</label>
                <input type="checkbox" name="category" id="버스정류장" value="버스정류장">
                <label for="버스정류장">버스정류장</label>
                <input type="checkbox" name="category" id="지하철" value="지하철">
                <label for="지하철">지하철</label>
                <input type="checkbox" name="category" id="주유소" value="주유소">
                <label for="주유소">주유소</label>
                <input type="checkbox" name="category" id="충전소" value="충전소">
                <label for="충전소">충전소</label>
                <input type="checkbox" name="category" id="주차장" value="주차장">
                <label for="주차장">주차장</label>
                <input type="checkbox" name="category" id="정비소" value="정비소">
                <label for="정비소">정비소</label>
                <hr>
                <input type="checkbox" name="category" id="영화관" value="영화관">
                <label for="영화관">영화관</label>
                <input type="checkbox" name="category" id="노래방" value="노래방">
                <label for="노래방">노래방</label>
                <input type="checkbox" name="category" id="PC방" value="PC방">
                <label for="PC방">PC방</label>
                <input type="checkbox" name="category" id="공연장" value="공연장">
                <label for="공연장">공연장</label>
                <input type="checkbox" name="category" id="문화시설" value="문화시설">
                <label for="문화시설">문화시설</label>
            </div>
            <div class="tag-buttons">
                <button class="tag-button" type="button" onclick="clearTags()">초기화</button>
                <button class="tag-button" type="button" data-target="category-box-container" onclick="toggleBox(this)">확인</button>
            </div>
        </div>
    </div>
</div>