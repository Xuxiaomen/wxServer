package ai.yale.wxserver.vo;

/**
 * 通过ticket换取二维码图片URL和LinkUrl
 * @author 徐梦
 *
 */
public class QRCodeResultVo {
	private String QRCodeImageUrl;
	private String QRCodeLinkUrl;
	public String getQRCodeImageUrl() {
		return QRCodeImageUrl;
	}
	public void setQRCodeImageUrl(String qRCodeImageUrl) {
		QRCodeImageUrl = qRCodeImageUrl;
	}
	public String getQRCodeLinkUrl() {
		return QRCodeLinkUrl;
	}
	public void setQRCodeLinkUrl(String qRCodeLinkUrl) {
		QRCodeLinkUrl = qRCodeLinkUrl;
	}
	@Override
	public String toString() {
		return "QRCodeResultVo [QRCodeImageUrl=" + QRCodeImageUrl + ", QRCodeLinkUrl=" + QRCodeLinkUrl + "]";
	}
	
}
