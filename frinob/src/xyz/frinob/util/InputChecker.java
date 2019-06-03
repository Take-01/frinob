package xyz.frinob.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class InputChecker {

	/**
	 * 正規表現を取得する。
	 *
	 * @param  number 1:半角英字 2:半角数字 3:ひらがな 4:カタカナ 5:漢字 6:全角記号 7:全角数字 8:半角記号
	 * @return 正規表現
	 *
	 */
	public String getRegex(int minLength, int maxLength, int ... number) {

		StringBuilder regex = new StringBuilder();
		regex.append("^[]{"+ minLength + "," + maxLength + "}$");
		int index = regex.lastIndexOf("]");

		for(int num:number) {
			switch(num) {
				case 1:
					regex.insert(index, "a-zA-Z");
					break;
				case 2:
					regex.insert(index, "0-9");
					break;
				case 3:
					regex.insert(index, "ぁ-ん");
					break;
				case 4:
					regex.insert(index, "ァ-ン");
					break;
				case 5:
					regex.insert(index, "一-龠々");
					break;
				case 6:
					regex.insert(index, "＠。、；：！”＃＄％＆’（）＝～｜－＾￥「｛＋＊」｝＜＞・？＿【】［］『』≪≫〔〕○●◎☆★◇◆□■△▲▽▼×±÷／");
					break;
				case 7:
					regex.insert(index, "０-９");
					break;
				case 8:
					regex.insert(index, "@.,;:!#$%&()'*+/=?^_`{|}~\\-");
					break;
			}
		}

		return regex.toString();
	}

	/**
	 * 文字数のチェックを行う。
	 *
	 * @param input チェックしたい文字列
	 * @param propertyName 項目名
	 * @param minLength 最小文字数
	 * @param maxLength 最大文字数
	 * @return 許容文字数のメッセージ
	 */
	public String checkLength(String input, String propertyName, int minLength, int maxLength) {

		String message = null;

		if(StringUtils.length(input) < minLength || StringUtils.length(input) > maxLength) {
			message = propertyName + "は" + minLength + "文字以上、" + maxLength + "文字以下で入力してください。";
		}

		return message;
	}

	/**
	 * 使用可能な文字種のメッセージを取得する。
	 *
	 * @param propertyName 項目名
	 * @param number 1:半角英字 2:半角数字 3:ひらがな 4:カタカナ 5:漢字 6:全角記号 7:全角数字 8:半角記号
	 * @return 項目に使用できる文字種のメッセージ
	 */
	public String getCharacterType(String propertyName, int ... number) {

		String characterType = propertyName + "は";

		for(int num:number) {
			switch(num) {
				case 1:
					characterType += "【半角英字】";
					break;
				case 2:
					characterType += "【半角数字】";
					break;
				case 3:
					characterType += "【ひらがな】";
					break;
				case 4:
					characterType += "【カタカナ】";
					break;
				case 5:
					characterType += "【漢字】";
					break;
				case 6:
					characterType += "【全角記号】";
					break;
				case 7:
					characterType += "【全角数字】";
					break;
				case 8:
					characterType += "【半角記号】";
					break;
			}
		}

		characterType += "のみ使用できます。";

		return characterType;
	}

	/**
	 * 入力値をチェックし、不正ならメッセージのリストを取得する。
	 * @param input 入力値
	 * @param propertyName 項目名
	 * @param minLength 最小文字数
	 * @param maxLength 最大文字数
	 * @param number  1:半角英字 2:半角数字 3:ひらがな 4:カタカナ 5:漢字 6:全角記号 7:全角数字 8:半角記号
	 * @return メッセージのリスト
	 */
	public List<String> getMessages(String input, String propertyName, int minLength, int maxLength, int ... number) {

		List<String> messageList = new ArrayList<String>();
		String regex = getRegex(minLength, maxLength, number);

		//文字数の警告メッセージを取得
		String lengthMessage = checkLength(input, propertyName, minLength, maxLength);
		if(lengthMessage != null) {
			messageList.add(lengthMessage);
		}

		//文字種の警告メッセージを取得
		if(input == null || !input.matches(regex)) {
			String charTypeMessage = getCharacterType(propertyName, number);
			messageList.add(charTypeMessage);
		}

		return messageList;
	}

	/**
	 * メールアドレスの入力チェックをする
	 * @param input チェックするメールアドレス
	 * @return 入力値が不正ならメッセージ
	 */
	public List<String> checkEmailAddress(String input) {

		List<String> messageList = new ArrayList<String>();
		String regularExpression = "^[\\w!#$%&'=^~{|}+*./?_-]+@[\\w-]+(\\.[\\w-]+)+$";
		if(input == null || !input.matches(regularExpression)) {
			messageList.add("登録できないメールアドレスです。");
			messageList.add("メールアドレスは【半角英数字記号】を使い、【xxx@xxx】の形式で入力してください。");
		}
		return messageList;
	}
}
