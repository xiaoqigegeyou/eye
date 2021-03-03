package cn.until;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * <p>
 * 划分List为几个不同大小的List【适用场景：mybatis分批次In查询，放置In拼接sql过长】
 * </p>
 *
 */
public class ListSplit {
	/**
	 * <p>
	 * 按照份数---划分list
	 * <p>
	 * 
	 * @param source
	 * @param num    想要划分成多少份
	 * @return
	 */
	public static <T> List<List<T>> splitListForNum(List<T> source, int num) {
		List<List<T>> result = new ArrayList<List<T>>();
		int remaider = source.size() % num; // (先计算出余数)
		int number = source.size() / num; // 然后是商
		int offset = 0;// 偏移量
		for (int i = 0; i < num; i++) {
			List<T> value = null;
			if (remaider > 0) {
				value = source.subList(i * number + offset, (i + 1) * number + offset + 1);
				remaider--;
				offset++;
			} else {
				value = source.subList(i * number + offset, (i + 1) * number + offset);
			}
			result.add(value);
		}
		return result;
	}

	/**
	 * <p>
	 * 根据目标容量 划分List
	 * <p>
	 * 
	 * @param source
	 * @param capacity 划分完成的单个List的最大容量
	 * @param          <T>
	 * @return
	 */
	public static <T> List<List<T>> splitListBycapacity(List<T> source, int capacity) {
		List<List<T>> result = new ArrayList<List<T>>();
		if (source != null && source.size() > 0) {
			int size = source.size();
			if (size < capacity) {
				result.add(source);
			} else {
				for (int i = 0; i < size;) {
					List<T> value = null;
					int end = i + capacity;
					if (end > size) {
						end = size;
					}
					value = source.subList(i, end);
					i = end;
					result.add(value);
				}
			}
		} else {
			result = null;
		}
		return result;
	}

}
