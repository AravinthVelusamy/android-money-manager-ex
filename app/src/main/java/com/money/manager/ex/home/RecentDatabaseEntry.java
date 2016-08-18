/*
 * Copyright (C) 2012-2016 The Android Money Manager Ex Project Team
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 3
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.money.manager.ex.home;

import java.io.File;

/**
 * An entry in the recent databases list.
 */
public class RecentDatabaseEntry {

    public static RecentDatabaseEntry getInstance(String filePath, boolean linkedToCloud, String remoteFileName) {
        //todo use TextUtils.isEmpty(remotePath) to identify if the entry is linked to a remote file.

        RecentDatabaseEntry entry = new RecentDatabaseEntry();
        entry.filePath = filePath;
        entry.linkedToCloud = linkedToCloud;
        entry.remoteFileName = remoteFileName;
        return entry;
    }

    /**
     * Creates an entry for a local file.
     * @param filePath Path to the local file.
     * @return Recent entry record that is not linked to a remote location.
     */
    public static RecentDatabaseEntry fromPath(String filePath) {
        return getInstance(filePath, false, "");
    }

    public String filePath;
    public String remoteFileName;
    public boolean linkedToCloud;

    public String getFileName() {
        File file = new File(this.filePath);
        return file.getName();
    }
}
