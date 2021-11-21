package com.js.effectivejava.item87;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringListTest {

    @Test
    @DisplayName("StringList 직렬화 및 역직렬화를 검증한다.")
    void testSerializeAndDeserialize() throws IOException, ClassNotFoundException {
        // given
        StringList stringList = new StringList();
        stringList.add("a");
        stringList.add("b");

        // when
        byte[] stringListInByte = serialize(stringList);
        StringList deserializedStringList = deserialize(stringListInByte);

        // then
        assertThat(deserializedStringList.size()).isEqualTo(2);
    }

    private byte[] serialize(StringList stringList) throws IOException {
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos)) {
            oos.writeObject(stringList);
            return bos.toByteArray();
        }
    }

    private StringList deserialize(byte[] stringListInByte)
        throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(stringListInByte))) {
            return (StringList) ois.readObject();
        }
    }
}