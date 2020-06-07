package com.example.domain;

/**
 * ステータスを表す列挙型
 * 
 * @author yuichiyasui
 * @apiNote 呼び出し方の例：Status.AVALABLE.getStatusId()
 */
public enum Status {
	BEFORE(0, "注文前"), NOTPAY(1, "未入金"), PAID(2, "入金済み"), SHIPPED(3, "発送済み"), CANCEL(9,"キャンセル");

	/** ステータスID */
	private final Integer statusId;
	/** ステータス名 */
	private final String statusName;

	private Status(final Integer statusId, final String statusName) {
		this.statusId = statusId;
		this.statusName = statusName;
	}

	public Integer getStatusId() {
		return statusId;
	}

	public String getStatusName() {
		return statusName;
	}

}
