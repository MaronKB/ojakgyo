<%@ page contentType="text/html;charset=UTF-8" %>
<div id="ad-modal-container" onclick="closeAdModal()">
    <form id="ad-modal" onsubmit="updateAd(this)" onclick="event.stopPropagation();">
        <input type="hidden" id="ad-modal-id" name="adId"/>
        <header id="ad-modal-header">
            <h3>광고 수정</h3>
            <a id="ad-modal-close" onclick="closeAdModal()"><i class="fa-solid fa-times"></i></a>
        </header>
        <div id="ad-modal-body">
            <div class="ad-modal-row">
                <label for="ad-modal-title">제목</label>
                <input id="ad-modal-title" type="text" name="title">
            </div>
            <div class="ad-modal-row">
                <label for="ad-modal-category">카테고리</label>
                <select id="ad-modal-category" name="category">
                    <option value="전체">전체</option>
                    <option value="식당">식당</option>
                    <option value="숙박">숙박</option>
                    <option value="렌터카">렌터카</option>
                </select>
            </div>
            <div class="ad-modal-row">
                <label for="ad-modal-end">종료일</label>
                <input id="ad-modal-end" type="date" name="end">
            </div>
            <div class="ad-modal-row">
                <input type="radio" id="ad-modal-enable" name="status" value="Y"/>
                <label for="ad-modal-enable">활성</label>
                <input type="radio" id="ad-modal-disable" name="status" value="N"/>
                <label for="ad-modal-disable">비활성</label>
            </div>
        </div>
        <footer id="ad-modal-footer">
            <button id="ad-modal-submit" type="submit">수정</button>
            <button id="ad-modal-delete" type="button" onclick="deleteAd()">삭제</button>
        </footer>
    </form>
</div>
