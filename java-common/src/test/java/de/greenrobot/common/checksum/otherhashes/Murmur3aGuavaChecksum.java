package de.greenrobot.common.checksum.otherhashes;

import com.google.common.hash.Hasher;
import com.google.common.hash.Hashing;

import java.util.zip.Checksum;

/** TODO */
public class Murmur3aGuavaChecksum implements Checksum {
    Hasher hasher = Hashing.murmur3_32().newHasher();

    @Override
    public void update(int b) {
        hasher.putByte((byte) b);
    }

    @Override
    public void update(byte[] b, int off, int len) {
        hasher.putBytes(b, off, len);
    }

    @Override
    public long getValue() {
        return 0xffffffffL & hasher.hash().asInt();
    }

    @Override
    public void reset() {
        hasher = Hashing.murmur3_32().newHasher();
    }
}