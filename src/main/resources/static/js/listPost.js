// $(document).ready(function() {
//     $("#categoryForum").on("click", function() {
//         alert("ajax 통신");
//         $.ajax({
//             type: "GET",
//             url: "/code/list",
//             contentType: "application/json; charset=UTF-8",
//             success : function(data) {
//                 alert(data);
//                 alert(JSON.stringify(data));
//
//                 $("#postdata").empty();
//
//                 let tablelist = `
//                     <table>
//                         <tr>
//                             <td ><b>번호</b></td>
//                             <td><b>제목</b></td>
//                             <td><b>작성자</b></td>
//                             <td><b>작성일</b></td>
//                             <td><b>조회수</b></td>
//                             <td><b>추천수</b></td>
//                         </tr>
//                 `;
//
//                 data.forEach(post => {
//                     tablelist += `
//                         <tr>
//                             <td>${post.post_id}</td>
//                             <td>${post.post_title}</td>
//                             <td>${post.post_author_nickname}</td>
//                             <td>${post.post_reg_date}</td>
//                             <td>${post.post_view_count}</td>
//                             <td>${post.post_vote_count}</td>
//                         </tr>
//                     `;
//                 });
//
//                 tablelist += `</table>`;
//
//                 $("#postdata").html(tablelist);
//             },
//             error: function(xhr, status, error) {
//                 alert("code" + xhr.status + "\n"
//                     +"message" + xhr.responseText + "\n"
//                     +"error:" + error);
//             }
//         });
//     });
// });


$(document).ready(function () {

    $(".btn").on("click", function () {
        const category = $(this).data("category");

        $.ajax({
            type: "GET",
            url: `/post/list?category=${category}`,
            contentType: "application/json; charset=UTF-8",
            success: function (data) {
                const tableBody = $("table.table tbody");
                tableBody.empty();

                if (data.length === 0) {
                    tableBody.append("<tr><td colspan='6'>해당 카테고리의 게시글이 없습니다.</td></tr>");
                    return;
                }

                data.forEach(post => {
                    const row = `
                        <tr>
                            <td><a href="/post/view.do?postId=${post.post_id}">${post.post_id}</a></td>
                            <td class="content"><a href="/post/view.do?postId=${post.post_id}">${post.post_title}</a></td>
                            <td><a href="/post/view.do?postId=${post.post_id}">${post.post_author_nickname}</a></td>
                            <td><a href="/post/view.do?postId=${post.post_id}">${post.post_reg_date}</a></td>
                            <td><a href="/post/view.do?postId=${post.post_id}">${post.post_view_count}</a></td>
                            <td><a href="/post/view.do?postId=${post.post_id}">${post.post_vote_count}</a></td>
                        </tr>
                    `;
                    tableBody.append(row);
                });
            },
            error: function(xhr, status, error) {
                alert("code" + xhr.status + "\n"
                    +"message" + xhr.responseText + "\n"
                    +"error:" + error);
            }
        });
    });
});
