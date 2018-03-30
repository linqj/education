package com.chinayouthedu.zqzc.common.utils;

import java.util.Comparator;

import com.chinayouthedu.zqzc.entity.paike.Activity;

public class CyeComparators {

	public static Comparator<Activity> ActivitySortComparator() {
		return new Comparator<Activity>() {

			@Override
			public int compare(Activity activity1, Activity activity2) {

				if (activity1 == null && activity2 == null) {
					return 1;
				}
				if (activity1 != null && activity2 == null) {
					return 1;
				}

				if (activity1 != null && activity2 != null
						&& activity1.getCreateTime().after(activity2.getCreateTime())) {
					return 1;
				}
				if (activity1 != null && activity2 != null
						&& activity1.getCreateTime().equals(activity2.getCreateTime())) {
					if (activity1.getUpdateTime().after(activity2.getUpdateTime())) {
						return 1;
					}
					if (activity1.getUpdateTime().equals(activity2.getUpdateTime())) {
						return 1;
					}
				}
				return -1;
			}
		};
	}
}
