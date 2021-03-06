/*
 * Copyright 2015-present Open Networking Foundation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.onosproject.pcepio.types;

import java.util.Objects;

import org.jboss.netty.buffer.ChannelBuffer;
import org.onosproject.pcepio.protocol.PcepVersion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.MoreObjects;

/**
 * Provides GMPLS Capability Tlv.
 */
public class GmplsCapabilityTlv implements PcepValueType {

    /*
     * GMPLS-CAPABILITY TLV format
     * reference :draft-ietf-pce-gmpls-pcep-extensions -2.1.1
    0                   1                   2                   3
    0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1
    +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
    |               Type=14       |             Length              |
    +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
    |                             Flags                             |
    +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
     */
    private static final Logger log = LoggerFactory.getLogger(GmplsCapabilityTlv.class);

    public static final short TYPE = 14;
    public static final short LENGTH = 4;

    private final int rawValue;

    /**
     * Constructor to initialize raw value.
     *
     * @param rawValue of Gmpls-Capability-Tlv
     */
    public GmplsCapabilityTlv(int rawValue) {
        this.rawValue = rawValue;
    }

    /**
     * Returns newly created GmplsCapabilityTlv object.
     *
     * @param raw Flags value
     * @return object of Gmpls-Capability-Tlv
     */
    public static GmplsCapabilityTlv of(final int raw) {
        return new GmplsCapabilityTlv(raw);
    }

    /**
     * Returns value of Flags.
     *
     * @return rawValue Flags
     */
    public int getInt() {
        return rawValue;
    }

    @Override
    public PcepVersion getVersion() {
        return PcepVersion.PCEP_1;
    }

    @Override
    public short getType() {
        return TYPE;
    }

    @Override
    public short getLength() {
        return LENGTH;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rawValue);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof GmplsCapabilityTlv) {
            GmplsCapabilityTlv other = (GmplsCapabilityTlv) obj;
            return Objects.equals(rawValue, other.rawValue);
        }
        return false;
    }

    @Override
    public int write(ChannelBuffer c) {
        int iLenStartIndex = c.writerIndex();
        c.writeShort(TYPE);
        c.writeShort(LENGTH);
        c.writeInt(rawValue);
        return c.writerIndex() - iLenStartIndex;
    }

    /**
     * Reads the channel buffer and returns object of Gmpls-Capability-Tlv.
     *
     * @param c input channel buffer
     * @return object of Gmpls-Capability-Tlv
     */
    public static GmplsCapabilityTlv read(ChannelBuffer c) {
        return GmplsCapabilityTlv.of(c.readInt());
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(getClass())
                .add("Type", TYPE)
                .add("Length", LENGTH)
                .add("Value", rawValue)
                .toString();
    }
}
