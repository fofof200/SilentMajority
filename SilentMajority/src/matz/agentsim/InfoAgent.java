package matz.agentsim;

import java.util.ArrayList;

public class InfoAgent {
	
	private String agentName;
	private int agentIndex;
	private ArrayList<String> followingNameList;
	private ArrayList<String> followedNameList;
	private ArrayList<Integer> followingIndexList;
	private ArrayList<Integer> followedIndexList;
	private boolean isSilent = false;
	private int Opinion;
	private final int NAME_BASED = 0;
	private final int INDEX_BASED = 1;
	private int style;
	
	/**文字列名を与えて情報エージェントを初期化するコンストラクタ．
	 * リストも全て文字列名で取り扱う．
	 * @param name -文字列の名前
	 * @param opinion -整数値の意見
	 * @param isSilent -サイレントであるか
	 */
	public InfoAgent(String name, int opinion, boolean isSilent) {
		this.setStyle(this.NAME_BASED);
		this.setAgentName(name);
		this.initFollowingNameList();
		this.initFollowedNameList();
		this.setOpinion(opinion);
		if (isSilent) this.muzzle();
	}
	
	/**文字列名を与えて情報エージェントを初期化するコンストラクタ．
	 * 全てサイレントでない（ヴォーカルである）ものとしている．
	 * @param name
	 * @param opinion
	 */
	public InfoAgent(String name, int opinion) {
		this.setStyle(this.NAME_BASED);
		this.setAgentName(name);
		this.initFollowingNameList();
		this.initFollowedNameList();
		this.setOpinion(opinion);	
	}
	
	/**整数識別番号を与えて情報エージェントを初期化するコンストラクタ．
	 * リストも全て識別番号で取り扱う．
	 * @param index -整数の識別番号
	 * @param opinion -整数値の意見
	 * @param isSilent -サイレントであるか
	 */
	public InfoAgent(int index, int opinion, boolean isSilent) {
		this.setStyle(this.INDEX_BASED);
		this.setAgentIndex(index);
		this.initFollowingIndexList();
		this.initFollowedIndexList();
		this.setOpinion(opinion);
		if (isSilent) this.muzzle();	
	}
	
	/**整数識別番号を与えて情報エージェントを初期化するコンストラクタ．
	 * 全てサイレントでない（ヴォーカルである）ものとしている．
	 * @param index -整数の識別番号
	 * @param opinion -整数値の意見
	 */
	public InfoAgent(int index, int opinion) {
		this.setStyle(this.INDEX_BASED);
		this.setAgentIndex(index);
		this.initFollowingIndexList();
		this.initFollowedIndexList();
		this.setOpinion(opinion);
	}
	
	/**情報エージェントの文字列名を取得．
	 * @return
	 */
	public String getAgentName() {
		return this.agentName;
	}
	/**情報エージェントの文字列名を指定．
	 * 
	 * @param agentName
	 */
	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}
	/**情報エージェントの整数識別番号を取得．
	 * @return
	 */
	public int getAgentIndex() {
		return this.agentIndex;
	}
	/**情報エージェントの整数識別番号を指定．
	 * @param agentIndex
	 */
	public void setAgentIndex(int agentIndex) {
		this.agentIndex = agentIndex;
	}
	
	/**以下，リスト関連のメソッド．
	 * ただし，これらのメソッドはprivateとし，内部でしか使わない．
	 * 最後にある型を自動判定するようにしたメソッド群のみpublicにする．
	 * 初期化メソッドもprivateとする．
	 */	
	
	/**情報エージェントが参照しているエージェントの文字列名リストを取得．
	 * @return
	 */
	private ArrayList<String> getFollowingNameList() {
		return this.followingNameList;
	}
	/**情報エージェントが参照しているエージェントの文字列名リストを空のリストに初期化．
	 */
	private void initFollowingNameList() {
		this.followingNameList = new ArrayList<String>();
	}
	/**情報エージェントが参照しているエージェントの文字列名リストに新たなエージェントの文字列名を追加．
	 * @param name
	 */
	private void appendFollowingNameList(String name) {
		this.followingNameList.add(name);
	}
	/**情報エージェントが参照されているエージェントの文字列名リストを取得．
	 * @return
	 */
	private ArrayList<String> getFollowedNameList() {
		return followedNameList;
	}
	/**情報エージェントが参照されているエージェントの文字列名リストを空のリストに初期化．
	 * 
	 */
	private void initFollowedNameList() {
		this.followedNameList = new ArrayList<String>();
	}
	/**情報エージェントが参照されているエージェントの文字列名リストに新たなエージェントの文字列名を追加．
	 * @param followedNameList
	 */
	private void appendFollowedNameList(String name) {
		this.followedNameList.add(name);
	}
	/**情報エージェントが参照しているエージェントの整数インデックスリストを取得。
	 * @return followingIndexList
	 */
	private ArrayList<Integer> getFollowingIndexList() {
		return followingIndexList;
	}
	/**情報エージェントが参照しているエージェントの整数インデックスリストを空のリストに初期化。
	 * @param followingIndexList セットする followingIndexList
	 */
	private void initFollowingIndexList() {
		this.followingIndexList = new ArrayList<Integer>();
	}
	/**情報エージェントが参照しているエージェントの整数インデックスリストに新たなエージェントの整数インデックスを追加。
	 * @param followingIndexList セットする followingIndexList
	 */
	private void appendFollowingIndexList(int index) {
		this.followingIndexList.add(index);
	}
	/**情報エージェントが参照されているエージェントの整数インデックスリストを取得。
	 * @return followedIndexList
	 */
	private ArrayList<Integer> getFollowedIndexList() {
		return followedIndexList;
	}
	/**情報エージェントが参照されているエージェントの整数インデックスリストを空のリストに初期化。
	 * @param followedIndexList セットする followedIndexList
	 */
	private void initFollowedIndexList() {
		this.followedIndexList = new ArrayList<Integer>();
	}
	/**情報エージェントが参照されているエージェントの整数インデックスリストに新たなエージェントの整数インデックスを追加。
	 * @param followedIndexList セットする followedIndexList
	 */
	private void appendFollowedIndexList(int index) {
		this.followedIndexList.add(index);
	}


	/**情報エージェントの定義に従い，適切なスタイルの参照リストを返す．
	 * @return 
	 */
	public ArrayList<?> getFollowingList() {
		if (this.getStyle() == this.NAME_BASED) {
			return this.getFollowingNameList();
		}
		return this.getFollowingIndexList();
	}
	/**情報エージェントの定義に従い，適切なスタイルの被参照リストを返す．
	 * @return 
	 */
	public ArrayList<?> getFollowedList() {
		if (this.getStyle() == this.NAME_BASED) {
			return this.getFollowedNameList();
		}
		return this.getFollowedIndexList();
	}
	/**情報エージェントの定義に従い，適切なスタイルの参照リストに新規エージェントを追加．
	 * StringかIntegerで引数を与える．
	 * @param nameOrIndex -StringかIntegerの値
	 */
	public <SorI> void appendFolowingList (SorI nameOrIndex) {
		if (this.getStyle() == this.NAME_BASED) {
			this.appendFollowingNameList((String) nameOrIndex);
		} else {
			this.appendFollowingIndexList((Integer) nameOrIndex);
		}
	}
	/**情報エージェントの定義に従い，適切なスタイルの被参照リストに新規エージェントを追加．
	 * StringかIntegerで引数を与える．
	 * @param nameOrIndex -StringかIntegerの値
	 */
	public <SorI> void appendFolowedList (SorI nameOrIndex) {
		if (this.getStyle() == this.NAME_BASED) {
			this.appendFollowedNameList((String) nameOrIndex);
		} else {
			this.appendFollowedIndexList((Integer) nameOrIndex);
		}
	}
	/**リンクが対象であるような無方向ネットワークの場合は参照リストと被参照リストどちらにもどうじに追加されるので，そのためのメソッド．
	 * @param nameOrIndex
	 */
	public <SorI> void appendIndirectedList (SorI nameOrIndex) {
		if (this.getStyle() == this.NAME_BASED) {
			this.appendFollowedNameList((String) nameOrIndex);
			this.appendFollowingNameList((String) nameOrIndex);
		} else {
			this.appendFollowedIndexList((Integer) nameOrIndex);
			this.appendFollowingIndexList((Integer) nameOrIndex);
		}
	}
	
	
	/**情報エージェントがサイレントであればtrue，ヴォーカルであればfalseを返す<br />
	 * デフォルトはfalse
	 * @return isSilent
	 */
	public boolean isSilent() {
		return isSilent;
	}
	/**情報エージェントをサイレントにする。
	 */
	public void muzzle() {
		this.isSilent = true;
	}
	/**情報エージェントをヴォーカルにする。
	 */
	public void unmuzzle() {
		this.isSilent = false;
	}
	/**情報エージェントの現在の意見を取得する。<br />
	 * エージェントがサイレントである場合は取得できない。null値を返す
	 * @return opinion
	 */
	public int getOpinion() {
		if (!this.isSilent()) {
			return Opinion;
		} else {
			return (Integer)null;
		}
	}
	/**情報エージェントの意見を指定する。
	 * @param opinion セットする opinion
	 */
	public void setOpinion(int opinion) {
		Opinion = opinion;
	}

	/**情報エージェントが文字列名ベースか整数識別番号ベースかどちらで管理されているか取得する．
	 * 文字列ベースならば0，整数ベースなら1を返す．
	 * @return nameOrIndex
	 */
	public int getStyle() {
		return style;
	}

	/**コンストラクタで呼ぶ．
	 * 文字列ベースのコンストラクタではNAME_BASEDを引数に入れる．
	 * 整数ベースのコンストラクタではINDEX_BASEDを引数に入れる．
	 * @param nameOrIndex セットする nameOrIndex
	 */
	public void setStyle(int nameOrIndex) {
		this.style = nameOrIndex;
	}
	
}
