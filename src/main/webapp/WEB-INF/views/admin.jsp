<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
    <head>
        <title>管理者画面</title>
        <link rel="stylesheet" href="css/admin/admin.css" />
        <link rel="stylesheet" href="css/common.css" />
        <script
  src="https://code.jquery.com/jquery-3.6.0.js"
  integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
  crossorigin="anonymous"></script>
    </head>
    <body>
        <header>
            <th>研修道場</th>
        </header>
        <div id="modal-overlay"></div>
	<div id="modal-content">
		<form:form action="/admin" modelAttribute="admin">
			<div class="createQuiz">
				<h3>クイズの作成</h3>
				<hr>
				<div>
					<label>
						カテゴリの選択
						<br>
						<form:select path="quizCategoryId"
							id="parentCategoryId">
						</form:select>
					</label>
				</div>
				<div>
					<label>
						クイズタイトル
						<br>
						<form:input path="createQuizTitle" />
					</label>
				</div>
				<div>
					<label>
						問題文
						<br>
						<form:textarea path="createProblemStatement" />
					</label>
				</div>
				<div>
					選択肢
					<br>
					<table>
						<tr>
							<th>1.</th>
							<td><form:input path="createChoice1" /></td>
						</tr>
						<tr>
							<th>2.</th>
							<td><form:input path="createChoice2" /></td>
						</tr>
						<tr>
							<th>3.</th>
							<td><form:input path="createChoice3" /></td>
						</tr>
						<tr>
							<th>4.</th>
							<td><form:input path="createChoice4" /></td>
						</tr>
					</table>
				</div>
				<div>
					解答
					<br>
					<form:select path="createAnswer">
						<form:option value="1">1.</form:option>
						<form:option value="2">2.</form:option>
						<form:option value="3">3.</form:option>
						<form:option value="4">4.</form:option>
					</form:select>
				</div>
				<div>
					解説
					<form:textarea path="createCommentary" />
				</div>
				<button type="button" class="return">戻る</button>
				<form:button name="quizCreate" class="update">更新</form:button>
			</div>
			<div class="editQuiz">
				<h3>クイズの編集</h3>
				<hr>
				<div>
					<label>
						カテゴリの選択
						<br>
						<form:select path="editQuizCategoryId">
						</form:select>
					</label>
				</div>
				<div>
					<label>
						クイズタイトル
						<br>
						<form:input path="editQuizTitle" />
					</label>
				</div>
				<div>
					<label>
						問題文
						<br>
						<form:textarea path="editProblemStatement" />
					</label>
				</div>
				<div>
					選択肢 <br>
					<table>
						<tr>
							<th>1.</th>
							<td><form:input path="editChoice1" /></td>
						</tr>
						<tr>
							<th>2.</th>
							<td><form:input path="editChoice2" /></td>
						</tr>
						<tr>
							<th>3.</th>
							<td><form:input path="editChoice3" /></td>
						</tr>
						<tr>
							<th>4.</th>
							<td><form:input path="editChoice4" /></td>
						</tr>
					</table>
				</div>
				<div>
					解答
					<br>
					<form:select path="editAnswer">
						<form:option value="1">1.</form:option>
						<form:option value="2">2.</form:option>
						<form:option value="3">3.</form:option>
						<form:option value="4">4.</form:option>
					</form:select>
				</div>
				<div>
					<label>
						非表示/表示
						<br>
						<form:checkbox path="quizDisplay" value="true"/>
					</label>
				</div>
				<div>
					解説
					<form:textarea path="editCommentary" />
				</div>
				<button type="button" class="return">戻る</button>
				<form:button name="quizEdit" class="update">更新</form:button>
			</div>
			<div class="createCategory">
				<h3>カテゴリの作成</h3>
				<hr>
				<div>
					<label>
						親カテゴリの選択
						<br>
						<form:select path="categoryParentCategoryId">
							<form:option value="">ルート</form:option>
						</form:select>
					</label>
				</div>
				<br>
				<div>
					<label>
						カテゴリ名
						<br>
						<form:input path="categoryName" />
					</label>
				</div>
				<button type="button" class="return">戻る</button>
				<form:button name="categoryCreate" class="update">更新</form:button>
			</div>
			<div class="editCategory">
				<h3>カテゴリの編集</h3>
				<hr>
				<div>
					<label>
						親カテゴリの選択
						<br>
						<form:select path="editCategoryParentCategoryId">
							<form:option value="">ルート</form:option>
						</form:select>
					</label>
				</div>
				<br>
				<div>
					<label>
						カテゴリ名の編集
						<br>
						<form:input path="editCategoryName" />
					</label>
				</div>
				<div>
					<label>
						非表示/表示
						<br>
						<form:checkbox path="categoryDisplay" value="true" />
					</label>
				</div>
				<button type="button" class="return">戻る</button>
				<form:button name="categoryEdit" class="update">更新</form:button>
			</div>
			<div class="editUser">
				<h3>ユーザーの編集</h3>
				<hr>
				<div>
					<label>
						ログインID
						<br>
						<form:select path="loginId">
							<form:option value="1">aaa</form:option>
							<form:option value="2">bbb</form:option>
						</form:select>
					</label>
				</div>
				<div>
					<label>
						権限選択
						<br>
						<form:select path="role">
							<form:option value="1">管理者</form:option>
							<form:option value="2">一般</form:option>
						</form:select>
					</label>
				</div>
				<button type="button" class="return">戻る</button>
				<form:button name="userEdit" class="update">更新</form:button>
			</div>
		</form:form>
	</div>


	<main>
            <div class="arrayContiner">
                <ul class="items">
                    <li id="createQuiz" class="item">クイズ作成</li>
                    <li id="editQuiz" class="item">クイズ編集</li>
                </ul>
                <ul class="items">
                    <li id="createCategory" class="item">カテゴリ作成</li>
                    <li id="editCategory" class="item">カテゴリ編集</li>
                </ul>
                <ul class="items">
                    <li id="editUser" class="item">ユーザー編集</li>
                </ul>
            </div>

            <div class="description">
                <h3>ボタン説明</h3>
                <ul>
                    <li>クイズ作成　 ... クイズで出題する問題を作成できます。</li>
                    <li>クイズ編集　 ... 作成したクイズの表示/非表示、クイズの更新ができます。</li>
                    <li>カテゴリ追加 ... 新しいクイズのカテゴリを作成できます。</li>
                    <li>カテゴリ編集 ... カテゴリの表示/非表示、名前の変更が設定できます。</li>
                    <li>ユーザー編集 ... ユーザーのアカウントに管理者権限を設定できます。</li>
                </ul>
            </div>
        </main>
        <script src="js/admin.js"></script>
    </body>
</html>