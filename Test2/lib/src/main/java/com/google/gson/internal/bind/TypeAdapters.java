package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.SerializedName;
import com.google.gson.internal.LazilyParsedNumber;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Currency;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import org.slf4j.Marker;

/* loaded from: classes.dex */
public final class TypeAdapters {
    public static final TypeAdapter<AtomicBoolean> ATOMIC_BOOLEAN;
    public static final TypeAdapterFactory ATOMIC_BOOLEAN_FACTORY;
    public static final TypeAdapter<AtomicInteger> ATOMIC_INTEGER;
    public static final TypeAdapter<AtomicIntegerArray> ATOMIC_INTEGER_ARRAY;
    public static final TypeAdapterFactory ATOMIC_INTEGER_ARRAY_FACTORY;
    public static final TypeAdapterFactory ATOMIC_INTEGER_FACTORY;
    public static final TypeAdapter<BigDecimal> BIG_DECIMAL;
    public static final TypeAdapter<BigInteger> BIG_INTEGER;
    public static final TypeAdapter<BitSet> BIT_SET;
    public static final TypeAdapterFactory BIT_SET_FACTORY;
    public static final TypeAdapter<Boolean> BOOLEAN;
    public static final TypeAdapter<Boolean> BOOLEAN_AS_STRING;
    public static final TypeAdapterFactory BOOLEAN_FACTORY;
    public static final TypeAdapter<Number> BYTE;
    public static final TypeAdapterFactory BYTE_FACTORY;
    public static final TypeAdapter<Calendar> CALENDAR;
    public static final TypeAdapterFactory CALENDAR_FACTORY;
    public static final TypeAdapter<Character> CHARACTER;
    public static final TypeAdapterFactory CHARACTER_FACTORY;
    public static final TypeAdapter<Class> CLASS;
    public static final TypeAdapterFactory CLASS_FACTORY;
    public static final TypeAdapter<Currency> CURRENCY;
    public static final TypeAdapterFactory CURRENCY_FACTORY;
    public static final TypeAdapter<Number> DOUBLE;
    public static final TypeAdapterFactory ENUM_FACTORY;
    public static final TypeAdapter<Number> FLOAT;
    public static final TypeAdapter<InetAddress> INET_ADDRESS;
    public static final TypeAdapterFactory INET_ADDRESS_FACTORY;
    public static final TypeAdapter<Number> INTEGER;
    public static final TypeAdapterFactory INTEGER_FACTORY;
    public static final TypeAdapter<JsonElement> JSON_ELEMENT;
    public static final TypeAdapterFactory JSON_ELEMENT_FACTORY;
    public static final TypeAdapter<Locale> LOCALE;
    public static final TypeAdapterFactory LOCALE_FACTORY;
    public static final TypeAdapter<Number> LONG;
    public static final TypeAdapter<Number> NUMBER;
    public static final TypeAdapterFactory NUMBER_FACTORY;
    public static final TypeAdapter<Number> SHORT;
    public static final TypeAdapterFactory SHORT_FACTORY;
    public static final TypeAdapter<String> STRING;
    public static final TypeAdapter<StringBuffer> STRING_BUFFER;
    public static final TypeAdapterFactory STRING_BUFFER_FACTORY;
    public static final TypeAdapter<StringBuilder> STRING_BUILDER;
    public static final TypeAdapterFactory STRING_BUILDER_FACTORY;
    public static final TypeAdapterFactory STRING_FACTORY;
    public static final TypeAdapterFactory TIMESTAMP_FACTORY;
    public static final TypeAdapter<URI> URI;
    public static final TypeAdapterFactory URI_FACTORY;
    public static final TypeAdapter<URL> URL;
    public static final TypeAdapterFactory URL_FACTORY;
    public static final TypeAdapter<UUID> UUID;
    public static final TypeAdapterFactory UUID_FACTORY;

    private TypeAdapters() {
        throw new UnsupportedOperationException();
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$1 */
    class C03691 extends TypeAdapter<Class> {
        C03691() {
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter out, Class value) throws IOException {
            throw new UnsupportedOperationException("Attempted to serialize java.lang.Class: " + value.getName() + ". Forgot to register a type adapter?");
        }

        @Override // com.google.gson.TypeAdapter
        public Class read(JsonReader in) throws IOException {
            throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
        }
    }

    static {
        TypeAdapter<Class> typeAdapterNullSafe = new TypeAdapter<Class>() { // from class: com.google.gson.internal.bind.TypeAdapters.1
            C03691() {
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter out, Class value) throws IOException {
                throw new UnsupportedOperationException("Attempted to serialize java.lang.Class: " + value.getName() + ". Forgot to register a type adapter?");
            }

            @Override // com.google.gson.TypeAdapter
            public Class read(JsonReader in) throws IOException {
                throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
            }
        }.nullSafe();
        CLASS = typeAdapterNullSafe;
        CLASS_FACTORY = newFactory(Class.class, typeAdapterNullSafe);
        TypeAdapter<BitSet> typeAdapterNullSafe2 = new TypeAdapter<BitSet>() { // from class: com.google.gson.internal.bind.TypeAdapters.2
            C03802() {
            }

            @Override // com.google.gson.TypeAdapter
            public BitSet read(JsonReader in) throws IOException {
                BitSet bitset = new BitSet();
                in.beginArray();
                int i = 0;
                JsonToken tokenType = in.peek();
                while (tokenType != JsonToken.END_ARRAY) {
                    int i2 = C039836.$SwitchMap$com$google$gson$stream$JsonToken[tokenType.ordinal()];
                    boolean set = false;
                    if (i2 != 1) {
                        if (i2 == 2) {
                            set = in.nextBoolean();
                        } else if (i2 == 3) {
                            String stringValue = in.nextString();
                            try {
                                if (Integer.parseInt(stringValue) != 0) {
                                    set = true;
                                }
                            } catch (NumberFormatException e) {
                                throw new JsonSyntaxException("Error: Expecting: bitset number value (1, 0), Found: " + stringValue);
                            }
                        } else {
                            throw new JsonSyntaxException("Invalid bitset value type: " + tokenType);
                        }
                    } else if (in.nextInt() != 0) {
                        set = true;
                    }
                    if (set) {
                        bitset.set(i);
                    }
                    i++;
                    tokenType = in.peek();
                }
                in.endArray();
                return bitset;
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, BitSet bitSet) throws IOException {
                jsonWriter.beginArray();
                int length = bitSet.length();
                for (int i = 0; i < length; i++) {
                    jsonWriter.value(bitSet.get(i) ? 1L : 0L);
                }
                jsonWriter.endArray();
            }
        }.nullSafe();
        BIT_SET = typeAdapterNullSafe2;
        BIT_SET_FACTORY = newFactory(BitSet.class, typeAdapterNullSafe2);
        BOOLEAN = new TypeAdapter<Boolean>() { // from class: com.google.gson.internal.bind.TypeAdapters.3
            C03913() {
            }

            @Override // com.google.gson.TypeAdapter
            public Boolean read(JsonReader in) throws IOException {
                JsonToken peek = in.peek();
                if (peek == JsonToken.NULL) {
                    in.nextNull();
                    return null;
                }
                if (peek == JsonToken.STRING) {
                    return Boolean.valueOf(Boolean.parseBoolean(in.nextString()));
                }
                return Boolean.valueOf(in.nextBoolean());
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter out, Boolean value) throws IOException {
                out.value(value);
            }
        };
        BOOLEAN_AS_STRING = new TypeAdapter<Boolean>() { // from class: com.google.gson.internal.bind.TypeAdapters.4
            C03994() {
            }

            @Override // com.google.gson.TypeAdapter
            public Boolean read(JsonReader in) throws IOException {
                if (in.peek() == JsonToken.NULL) {
                    in.nextNull();
                    return null;
                }
                return Boolean.valueOf(in.nextString());
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter out, Boolean value) throws IOException {
                out.value(value == null ? "null" : value.toString());
            }
        };
        BOOLEAN_FACTORY = newFactory(Boolean.TYPE, Boolean.class, BOOLEAN);
        BYTE = new TypeAdapter<Number>() { // from class: com.google.gson.internal.bind.TypeAdapters.5
            C04005() {
            }

            @Override // com.google.gson.TypeAdapter
            public Number read(JsonReader in) throws IOException {
                if (in.peek() == JsonToken.NULL) {
                    in.nextNull();
                    return null;
                }
                try {
                    int intValue = in.nextInt();
                    return Byte.valueOf((byte) intValue);
                } catch (NumberFormatException e) {
                    throw new JsonSyntaxException(e);
                }
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter out, Number value) throws IOException {
                out.value(value);
            }
        };
        BYTE_FACTORY = newFactory(Byte.TYPE, Byte.class, BYTE);
        SHORT = new TypeAdapter<Number>() { // from class: com.google.gson.internal.bind.TypeAdapters.6
            C04016() {
            }

            @Override // com.google.gson.TypeAdapter
            public Number read(JsonReader in) throws IOException {
                if (in.peek() == JsonToken.NULL) {
                    in.nextNull();
                    return null;
                }
                try {
                    return Short.valueOf((short) in.nextInt());
                } catch (NumberFormatException e) {
                    throw new JsonSyntaxException(e);
                }
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter out, Number value) throws IOException {
                out.value(value);
            }
        };
        SHORT_FACTORY = newFactory(Short.TYPE, Short.class, SHORT);
        INTEGER = new TypeAdapter<Number>() { // from class: com.google.gson.internal.bind.TypeAdapters.7
            C04027() {
            }

            @Override // com.google.gson.TypeAdapter
            public Number read(JsonReader in) throws IOException {
                if (in.peek() == JsonToken.NULL) {
                    in.nextNull();
                    return null;
                }
                try {
                    return Integer.valueOf(in.nextInt());
                } catch (NumberFormatException e) {
                    throw new JsonSyntaxException(e);
                }
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter out, Number value) throws IOException {
                out.value(value);
            }
        };
        INTEGER_FACTORY = newFactory(Integer.TYPE, Integer.class, INTEGER);
        TypeAdapter<AtomicInteger> typeAdapterNullSafe3 = new TypeAdapter<AtomicInteger>() { // from class: com.google.gson.internal.bind.TypeAdapters.8
            C04038() {
            }

            @Override // com.google.gson.TypeAdapter
            public AtomicInteger read(JsonReader in) throws IOException {
                try {
                    return new AtomicInteger(in.nextInt());
                } catch (NumberFormatException e) {
                    throw new JsonSyntaxException(e);
                }
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter out, AtomicInteger value) throws IOException {
                out.value(value.get());
            }
        }.nullSafe();
        ATOMIC_INTEGER = typeAdapterNullSafe3;
        ATOMIC_INTEGER_FACTORY = newFactory(AtomicInteger.class, typeAdapterNullSafe3);
        TypeAdapter<AtomicBoolean> typeAdapterNullSafe4 = new TypeAdapter<AtomicBoolean>() { // from class: com.google.gson.internal.bind.TypeAdapters.9
            C04049() {
            }

            @Override // com.google.gson.TypeAdapter
            public AtomicBoolean read(JsonReader in) throws IOException {
                return new AtomicBoolean(in.nextBoolean());
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter out, AtomicBoolean value) throws IOException {
                out.value(value.get());
            }
        }.nullSafe();
        ATOMIC_BOOLEAN = typeAdapterNullSafe4;
        ATOMIC_BOOLEAN_FACTORY = newFactory(AtomicBoolean.class, typeAdapterNullSafe4);
        TypeAdapter<AtomicIntegerArray> typeAdapterNullSafe5 = new TypeAdapter<AtomicIntegerArray>() { // from class: com.google.gson.internal.bind.TypeAdapters.10
            C037010() {
            }

            @Override // com.google.gson.TypeAdapter
            public AtomicIntegerArray read(JsonReader in) throws IOException {
                List<Integer> list = new ArrayList<>();
                in.beginArray();
                while (in.hasNext()) {
                    try {
                        int integer = in.nextInt();
                        list.add(Integer.valueOf(integer));
                    } catch (NumberFormatException e) {
                        throw new JsonSyntaxException(e);
                    }
                }
                in.endArray();
                int length = list.size();
                AtomicIntegerArray array = new AtomicIntegerArray(length);
                for (int i = 0; i < length; i++) {
                    array.set(i, list.get(i).intValue());
                }
                return array;
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter out, AtomicIntegerArray value) throws IOException {
                out.beginArray();
                int length = value.length();
                for (int i = 0; i < length; i++) {
                    out.value(value.get(i));
                }
                out.endArray();
            }
        }.nullSafe();
        ATOMIC_INTEGER_ARRAY = typeAdapterNullSafe5;
        ATOMIC_INTEGER_ARRAY_FACTORY = newFactory(AtomicIntegerArray.class, typeAdapterNullSafe5);
        LONG = new TypeAdapter<Number>() { // from class: com.google.gson.internal.bind.TypeAdapters.11
            C037111() {
            }

            @Override // com.google.gson.TypeAdapter
            public Number read(JsonReader in) throws IOException {
                if (in.peek() == JsonToken.NULL) {
                    in.nextNull();
                    return null;
                }
                try {
                    return Long.valueOf(in.nextLong());
                } catch (NumberFormatException e) {
                    throw new JsonSyntaxException(e);
                }
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter out, Number value) throws IOException {
                out.value(value);
            }
        };
        FLOAT = new TypeAdapter<Number>() { // from class: com.google.gson.internal.bind.TypeAdapters.12
            C037212() {
            }

            @Override // com.google.gson.TypeAdapter
            public Number read(JsonReader in) throws IOException {
                if (in.peek() == JsonToken.NULL) {
                    in.nextNull();
                    return null;
                }
                return Float.valueOf((float) in.nextDouble());
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter out, Number value) throws IOException {
                out.value(value);
            }
        };
        DOUBLE = new TypeAdapter<Number>() { // from class: com.google.gson.internal.bind.TypeAdapters.13
            C037313() {
            }

            @Override // com.google.gson.TypeAdapter
            public Number read(JsonReader in) throws IOException {
                if (in.peek() == JsonToken.NULL) {
                    in.nextNull();
                    return null;
                }
                return Double.valueOf(in.nextDouble());
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter out, Number value) throws IOException {
                out.value(value);
            }
        };
        C037414 c037414 = new TypeAdapter<Number>() { // from class: com.google.gson.internal.bind.TypeAdapters.14
            C037414() {
            }

            @Override // com.google.gson.TypeAdapter
            public Number read(JsonReader in) throws IOException {
                JsonToken jsonToken = in.peek();
                int i = C039836.$SwitchMap$com$google$gson$stream$JsonToken[jsonToken.ordinal()];
                if (i == 1 || i == 3) {
                    return new LazilyParsedNumber(in.nextString());
                }
                if (i == 4) {
                    in.nextNull();
                    return null;
                }
                throw new JsonSyntaxException("Expecting number, got: " + jsonToken);
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter out, Number value) throws IOException {
                out.value(value);
            }
        };
        NUMBER = c037414;
        NUMBER_FACTORY = newFactory(Number.class, c037414);
        CHARACTER = new TypeAdapter<Character>() { // from class: com.google.gson.internal.bind.TypeAdapters.15
            C037515() {
            }

            @Override // com.google.gson.TypeAdapter
            public Character read(JsonReader in) throws IOException {
                if (in.peek() == JsonToken.NULL) {
                    in.nextNull();
                    return null;
                }
                String str = in.nextString();
                if (str.length() != 1) {
                    throw new JsonSyntaxException("Expecting character, got: " + str);
                }
                return Character.valueOf(str.charAt(0));
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter out, Character value) throws IOException {
                out.value(value == null ? null : String.valueOf(value));
            }
        };
        CHARACTER_FACTORY = newFactory(Character.TYPE, Character.class, CHARACTER);
        STRING = new TypeAdapter<String>() { // from class: com.google.gson.internal.bind.TypeAdapters.16
            C037616() {
            }

            @Override // com.google.gson.TypeAdapter
            public String read(JsonReader in) throws IOException {
                JsonToken peek = in.peek();
                if (peek == JsonToken.NULL) {
                    in.nextNull();
                    return null;
                }
                if (peek == JsonToken.BOOLEAN) {
                    return Boolean.toString(in.nextBoolean());
                }
                return in.nextString();
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter out, String value) throws IOException {
                out.value(value);
            }
        };
        BIG_DECIMAL = new TypeAdapter<BigDecimal>() { // from class: com.google.gson.internal.bind.TypeAdapters.17
            C037717() {
            }

            @Override // com.google.gson.TypeAdapter
            public BigDecimal read(JsonReader in) throws IOException {
                if (in.peek() == JsonToken.NULL) {
                    in.nextNull();
                    return null;
                }
                try {
                    return new BigDecimal(in.nextString());
                } catch (NumberFormatException e) {
                    throw new JsonSyntaxException(e);
                }
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter out, BigDecimal value) throws IOException {
                out.value(value);
            }
        };
        BIG_INTEGER = new TypeAdapter<BigInteger>() { // from class: com.google.gson.internal.bind.TypeAdapters.18
            C037818() {
            }

            @Override // com.google.gson.TypeAdapter
            public BigInteger read(JsonReader in) throws IOException {
                if (in.peek() == JsonToken.NULL) {
                    in.nextNull();
                    return null;
                }
                try {
                    return new BigInteger(in.nextString());
                } catch (NumberFormatException e) {
                    throw new JsonSyntaxException(e);
                }
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter out, BigInteger value) throws IOException {
                out.value(value);
            }
        };
        STRING_FACTORY = newFactory(String.class, STRING);
        C037919 c037919 = new TypeAdapter<StringBuilder>() { // from class: com.google.gson.internal.bind.TypeAdapters.19
            C037919() {
            }

            @Override // com.google.gson.TypeAdapter
            public StringBuilder read(JsonReader in) throws IOException {
                if (in.peek() == JsonToken.NULL) {
                    in.nextNull();
                    return null;
                }
                return new StringBuilder(in.nextString());
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter out, StringBuilder value) throws IOException {
                out.value(value == null ? null : value.toString());
            }
        };
        STRING_BUILDER = c037919;
        STRING_BUILDER_FACTORY = newFactory(StringBuilder.class, c037919);
        C038120 c038120 = new TypeAdapter<StringBuffer>() { // from class: com.google.gson.internal.bind.TypeAdapters.20
            C038120() {
            }

            @Override // com.google.gson.TypeAdapter
            public StringBuffer read(JsonReader in) throws IOException {
                if (in.peek() == JsonToken.NULL) {
                    in.nextNull();
                    return null;
                }
                return new StringBuffer(in.nextString());
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter out, StringBuffer value) throws IOException {
                out.value(value == null ? null : value.toString());
            }
        };
        STRING_BUFFER = c038120;
        STRING_BUFFER_FACTORY = newFactory(StringBuffer.class, c038120);
        C038221 c038221 = new TypeAdapter<URL>() { // from class: com.google.gson.internal.bind.TypeAdapters.21
            C038221() {
            }

            @Override // com.google.gson.TypeAdapter
            public URL read(JsonReader in) throws IOException {
                if (in.peek() == JsonToken.NULL) {
                    in.nextNull();
                    return null;
                }
                String nextString = in.nextString();
                if ("null".equals(nextString)) {
                    return null;
                }
                return new URL(nextString);
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter out, URL value) throws IOException {
                out.value(value == null ? null : value.toExternalForm());
            }
        };
        URL = c038221;
        URL_FACTORY = newFactory(URL.class, c038221);
        C038322 c038322 = new TypeAdapter<URI>() { // from class: com.google.gson.internal.bind.TypeAdapters.22
            C038322() {
            }

            @Override // com.google.gson.TypeAdapter
            public URI read(JsonReader in) throws IOException {
                if (in.peek() == JsonToken.NULL) {
                    in.nextNull();
                    return null;
                }
                try {
                    String nextString = in.nextString();
                    return "null".equals(nextString) ? null : new URI(nextString);
                } catch (URISyntaxException e) {
                    throw new JsonIOException(e);
                }
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter out, URI value) throws IOException {
                out.value(value == null ? null : value.toASCIIString());
            }
        };
        URI = c038322;
        URI_FACTORY = newFactory(URI.class, c038322);
        C038423 c038423 = new TypeAdapter<InetAddress>() { // from class: com.google.gson.internal.bind.TypeAdapters.23
            C038423() {
            }

            @Override // com.google.gson.TypeAdapter
            public InetAddress read(JsonReader in) throws IOException {
                if (in.peek() == JsonToken.NULL) {
                    in.nextNull();
                    return null;
                }
                return InetAddress.getByName(in.nextString());
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter out, InetAddress value) throws IOException {
                out.value(value == null ? null : value.getHostAddress());
            }
        };
        INET_ADDRESS = c038423;
        INET_ADDRESS_FACTORY = newTypeHierarchyFactory(InetAddress.class, c038423);
        C038524 c038524 = new TypeAdapter<UUID>() { // from class: com.google.gson.internal.bind.TypeAdapters.24
            C038524() {
            }

            @Override // com.google.gson.TypeAdapter
            public UUID read(JsonReader in) throws IOException {
                if (in.peek() == JsonToken.NULL) {
                    in.nextNull();
                    return null;
                }
                return UUID.fromString(in.nextString());
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter out, UUID value) throws IOException {
                out.value(value == null ? null : value.toString());
            }
        };
        UUID = c038524;
        UUID_FACTORY = newFactory(UUID.class, c038524);
        TypeAdapter<Currency> typeAdapterNullSafe6 = new TypeAdapter<Currency>() { // from class: com.google.gson.internal.bind.TypeAdapters.25
            C038625() {
            }

            @Override // com.google.gson.TypeAdapter
            public Currency read(JsonReader in) throws IOException {
                return Currency.getInstance(in.nextString());
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter out, Currency value) throws IOException {
                out.value(value.getCurrencyCode());
            }
        }.nullSafe();
        CURRENCY = typeAdapterNullSafe6;
        CURRENCY_FACTORY = newFactory(Currency.class, typeAdapterNullSafe6);
        TIMESTAMP_FACTORY = new TypeAdapterFactory() { // from class: com.google.gson.internal.bind.TypeAdapters.26
            C038726() {
            }

            @Override // com.google.gson.TypeAdapterFactory
            public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
                if (typeToken.getRawType() != Timestamp.class) {
                    return null;
                }
                return new TypeAdapter<Timestamp>() { // from class: com.google.gson.internal.bind.TypeAdapters.26.1
                    final /* synthetic */ TypeAdapter val$dateTypeAdapter;

                    AnonymousClass1(TypeAdapter typeAdapter) {
                        typeAdapter = typeAdapter;
                    }

                    @Override // com.google.gson.TypeAdapter
                    public Timestamp read(JsonReader in) throws IOException {
                        Date date = (Date) typeAdapter.read(in);
                        if (date != null) {
                            return new Timestamp(date.getTime());
                        }
                        return null;
                    }

                    @Override // com.google.gson.TypeAdapter
                    public void write(JsonWriter out, Timestamp value) throws IOException {
                        typeAdapter.write(out, value);
                    }
                };
            }

            /* renamed from: com.google.gson.internal.bind.TypeAdapters$26$1 */
            class AnonymousClass1 extends TypeAdapter<Timestamp> {
                final /* synthetic */ TypeAdapter val$dateTypeAdapter;

                AnonymousClass1(TypeAdapter typeAdapter) {
                    typeAdapter = typeAdapter;
                }

                @Override // com.google.gson.TypeAdapter
                public Timestamp read(JsonReader in) throws IOException {
                    Date date = (Date) typeAdapter.read(in);
                    if (date != null) {
                        return new Timestamp(date.getTime());
                    }
                    return null;
                }

                @Override // com.google.gson.TypeAdapter
                public void write(JsonWriter out, Timestamp value) throws IOException {
                    typeAdapter.write(out, value);
                }
            }
        };
        C038827 c038827 = new TypeAdapter<Calendar>() { // from class: com.google.gson.internal.bind.TypeAdapters.27
            private static final String DAY_OF_MONTH = "dayOfMonth";
            private static final String HOUR_OF_DAY = "hourOfDay";
            private static final String MINUTE = "minute";
            private static final String MONTH = "month";
            private static final String SECOND = "second";
            private static final String YEAR = "year";

            C038827() {
            }

            @Override // com.google.gson.TypeAdapter
            public Calendar read(JsonReader in) throws IOException, NumberFormatException {
                if (in.peek() == JsonToken.NULL) {
                    in.nextNull();
                    return null;
                }
                in.beginObject();
                int year = 0;
                int month = 0;
                int dayOfMonth = 0;
                int hourOfDay = 0;
                int minute = 0;
                int second = 0;
                while (in.peek() != JsonToken.END_OBJECT) {
                    String name = in.nextName();
                    int value = in.nextInt();
                    if (YEAR.equals(name)) {
                        year = value;
                    } else if (MONTH.equals(name)) {
                        month = value;
                    } else if (DAY_OF_MONTH.equals(name)) {
                        dayOfMonth = value;
                    } else if (HOUR_OF_DAY.equals(name)) {
                        hourOfDay = value;
                    } else if (MINUTE.equals(name)) {
                        minute = value;
                    } else if (SECOND.equals(name)) {
                        second = value;
                    }
                }
                in.endObject();
                return new GregorianCalendar(year, month, dayOfMonth, hourOfDay, minute, second);
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter out, Calendar value) throws IOException {
                if (value == null) {
                    out.nullValue();
                    return;
                }
                out.beginObject();
                out.name(YEAR);
                out.value(value.get(1));
                out.name(MONTH);
                out.value(value.get(2));
                out.name(DAY_OF_MONTH);
                out.value(value.get(5));
                out.name(HOUR_OF_DAY);
                out.value(value.get(11));
                out.name(MINUTE);
                out.value(value.get(12));
                out.name(SECOND);
                out.value(value.get(13));
                out.endObject();
            }
        };
        CALENDAR = c038827;
        CALENDAR_FACTORY = newFactoryForMultipleTypes(Calendar.class, GregorianCalendar.class, c038827);
        C038928 c038928 = new TypeAdapter<Locale>() { // from class: com.google.gson.internal.bind.TypeAdapters.28
            C038928() {
            }

            @Override // com.google.gson.TypeAdapter
            public Locale read(JsonReader in) throws IOException {
                if (in.peek() == JsonToken.NULL) {
                    in.nextNull();
                    return null;
                }
                String locale = in.nextString();
                StringTokenizer tokenizer = new StringTokenizer(locale, "_");
                String language = null;
                String country = null;
                String variant = null;
                if (tokenizer.hasMoreElements()) {
                    language = tokenizer.nextToken();
                }
                if (tokenizer.hasMoreElements()) {
                    country = tokenizer.nextToken();
                }
                if (tokenizer.hasMoreElements()) {
                    variant = tokenizer.nextToken();
                }
                if (country == null && variant == null) {
                    return new Locale(language);
                }
                if (variant == null) {
                    return new Locale(language, country);
                }
                return new Locale(language, country, variant);
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter out, Locale value) throws IOException {
                out.value(value == null ? null : value.toString());
            }
        };
        LOCALE = c038928;
        LOCALE_FACTORY = newFactory(Locale.class, c038928);
        C039029 c039029 = new TypeAdapter<JsonElement>() { // from class: com.google.gson.internal.bind.TypeAdapters.29
            C039029() {
            }

            @Override // com.google.gson.TypeAdapter
            public JsonElement read(JsonReader in) throws IOException {
                switch (C039836.$SwitchMap$com$google$gson$stream$JsonToken[in.peek().ordinal()]) {
                    case 1:
                        String number = in.nextString();
                        return new JsonPrimitive(new LazilyParsedNumber(number));
                    case 2:
                        return new JsonPrimitive(Boolean.valueOf(in.nextBoolean()));
                    case 3:
                        return new JsonPrimitive(in.nextString());
                    case 4:
                        in.nextNull();
                        return JsonNull.INSTANCE;
                    case 5:
                        JsonArray array = new JsonArray();
                        in.beginArray();
                        while (in.hasNext()) {
                            array.add(read(in));
                        }
                        in.endArray();
                        return array;
                    case 6:
                        JsonObject object = new JsonObject();
                        in.beginObject();
                        while (in.hasNext()) {
                            object.add(in.nextName(), read(in));
                        }
                        in.endObject();
                        return object;
                    default:
                        throw new IllegalArgumentException();
                }
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter out, JsonElement value) throws IOException {
                if (value == null || value.isJsonNull()) {
                    out.nullValue();
                    return;
                }
                if (value.isJsonPrimitive()) {
                    JsonPrimitive primitive = value.getAsJsonPrimitive();
                    if (primitive.isNumber()) {
                        out.value(primitive.getAsNumber());
                        return;
                    } else if (primitive.isBoolean()) {
                        out.value(primitive.getAsBoolean());
                        return;
                    } else {
                        out.value(primitive.getAsString());
                        return;
                    }
                }
                if (value.isJsonArray()) {
                    out.beginArray();
                    Iterator<JsonElement> it = value.getAsJsonArray().iterator();
                    while (it.hasNext()) {
                        write(out, it.next());
                    }
                    out.endArray();
                    return;
                }
                if (value.isJsonObject()) {
                    out.beginObject();
                    for (Map.Entry<String, JsonElement> e : value.getAsJsonObject().entrySet()) {
                        out.name(e.getKey());
                        write(out, e.getValue());
                    }
                    out.endObject();
                    return;
                }
                throw new IllegalArgumentException("Couldn't write " + value.getClass());
            }
        };
        JSON_ELEMENT = c039029;
        JSON_ELEMENT_FACTORY = newTypeHierarchyFactory(JsonElement.class, c039029);
        ENUM_FACTORY = new TypeAdapterFactory() { // from class: com.google.gson.internal.bind.TypeAdapters.30
            C039230() {
            }

            @Override // com.google.gson.TypeAdapterFactory
            public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
                Class<? super T> rawType = typeToken.getRawType();
                if (!Enum.class.isAssignableFrom(rawType) || rawType == Enum.class) {
                    return null;
                }
                if (!rawType.isEnum()) {
                    rawType = rawType.getSuperclass();
                }
                return new EnumTypeAdapter(rawType);
            }
        };
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$2 */
    class C03802 extends TypeAdapter<BitSet> {
        C03802() {
        }

        @Override // com.google.gson.TypeAdapter
        public BitSet read(JsonReader in) throws IOException {
            BitSet bitset = new BitSet();
            in.beginArray();
            int i = 0;
            JsonToken tokenType = in.peek();
            while (tokenType != JsonToken.END_ARRAY) {
                int i2 = C039836.$SwitchMap$com$google$gson$stream$JsonToken[tokenType.ordinal()];
                boolean set = false;
                if (i2 != 1) {
                    if (i2 == 2) {
                        set = in.nextBoolean();
                    } else if (i2 == 3) {
                        String stringValue = in.nextString();
                        try {
                            if (Integer.parseInt(stringValue) != 0) {
                                set = true;
                            }
                        } catch (NumberFormatException e) {
                            throw new JsonSyntaxException("Error: Expecting: bitset number value (1, 0), Found: " + stringValue);
                        }
                    } else {
                        throw new JsonSyntaxException("Invalid bitset value type: " + tokenType);
                    }
                } else if (in.nextInt() != 0) {
                    set = true;
                }
                if (set) {
                    bitset.set(i);
                }
                i++;
                tokenType = in.peek();
            }
            in.endArray();
            return bitset;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, BitSet bitSet) throws IOException {
            jsonWriter.beginArray();
            int length = bitSet.length();
            for (int i = 0; i < length; i++) {
                jsonWriter.value(bitSet.get(i) ? 1L : 0L);
            }
            jsonWriter.endArray();
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$36 */
    static /* synthetic */ class C039836 {
        static final /* synthetic */ int[] $SwitchMap$com$google$gson$stream$JsonToken;

        static {
            int[] iArr = new int[JsonToken.values().length];
            $SwitchMap$com$google$gson$stream$JsonToken = iArr;
            try {
                iArr[JsonToken.NUMBER.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.BOOLEAN.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.NULL.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.BEGIN_ARRAY.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.BEGIN_OBJECT.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.END_DOCUMENT.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.NAME.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.END_OBJECT.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.END_ARRAY.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$3 */
    class C03913 extends TypeAdapter<Boolean> {
        C03913() {
        }

        @Override // com.google.gson.TypeAdapter
        public Boolean read(JsonReader in) throws IOException {
            JsonToken peek = in.peek();
            if (peek == JsonToken.NULL) {
                in.nextNull();
                return null;
            }
            if (peek == JsonToken.STRING) {
                return Boolean.valueOf(Boolean.parseBoolean(in.nextString()));
            }
            return Boolean.valueOf(in.nextBoolean());
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter out, Boolean value) throws IOException {
            out.value(value);
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$4 */
    class C03994 extends TypeAdapter<Boolean> {
        C03994() {
        }

        @Override // com.google.gson.TypeAdapter
        public Boolean read(JsonReader in) throws IOException {
            if (in.peek() == JsonToken.NULL) {
                in.nextNull();
                return null;
            }
            return Boolean.valueOf(in.nextString());
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter out, Boolean value) throws IOException {
            out.value(value == null ? "null" : value.toString());
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$5 */
    class C04005 extends TypeAdapter<Number> {
        C04005() {
        }

        @Override // com.google.gson.TypeAdapter
        public Number read(JsonReader in) throws IOException {
            if (in.peek() == JsonToken.NULL) {
                in.nextNull();
                return null;
            }
            try {
                int intValue = in.nextInt();
                return Byte.valueOf((byte) intValue);
            } catch (NumberFormatException e) {
                throw new JsonSyntaxException(e);
            }
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter out, Number value) throws IOException {
            out.value(value);
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$6 */
    class C04016 extends TypeAdapter<Number> {
        C04016() {
        }

        @Override // com.google.gson.TypeAdapter
        public Number read(JsonReader in) throws IOException {
            if (in.peek() == JsonToken.NULL) {
                in.nextNull();
                return null;
            }
            try {
                return Short.valueOf((short) in.nextInt());
            } catch (NumberFormatException e) {
                throw new JsonSyntaxException(e);
            }
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter out, Number value) throws IOException {
            out.value(value);
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$7 */
    class C04027 extends TypeAdapter<Number> {
        C04027() {
        }

        @Override // com.google.gson.TypeAdapter
        public Number read(JsonReader in) throws IOException {
            if (in.peek() == JsonToken.NULL) {
                in.nextNull();
                return null;
            }
            try {
                return Integer.valueOf(in.nextInt());
            } catch (NumberFormatException e) {
                throw new JsonSyntaxException(e);
            }
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter out, Number value) throws IOException {
            out.value(value);
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$8 */
    class C04038 extends TypeAdapter<AtomicInteger> {
        C04038() {
        }

        @Override // com.google.gson.TypeAdapter
        public AtomicInteger read(JsonReader in) throws IOException {
            try {
                return new AtomicInteger(in.nextInt());
            } catch (NumberFormatException e) {
                throw new JsonSyntaxException(e);
            }
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter out, AtomicInteger value) throws IOException {
            out.value(value.get());
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$9 */
    class C04049 extends TypeAdapter<AtomicBoolean> {
        C04049() {
        }

        @Override // com.google.gson.TypeAdapter
        public AtomicBoolean read(JsonReader in) throws IOException {
            return new AtomicBoolean(in.nextBoolean());
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter out, AtomicBoolean value) throws IOException {
            out.value(value.get());
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$10 */
    class C037010 extends TypeAdapter<AtomicIntegerArray> {
        C037010() {
        }

        @Override // com.google.gson.TypeAdapter
        public AtomicIntegerArray read(JsonReader in) throws IOException {
            List<Integer> list = new ArrayList<>();
            in.beginArray();
            while (in.hasNext()) {
                try {
                    int integer = in.nextInt();
                    list.add(Integer.valueOf(integer));
                } catch (NumberFormatException e) {
                    throw new JsonSyntaxException(e);
                }
            }
            in.endArray();
            int length = list.size();
            AtomicIntegerArray array = new AtomicIntegerArray(length);
            for (int i = 0; i < length; i++) {
                array.set(i, list.get(i).intValue());
            }
            return array;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter out, AtomicIntegerArray value) throws IOException {
            out.beginArray();
            int length = value.length();
            for (int i = 0; i < length; i++) {
                out.value(value.get(i));
            }
            out.endArray();
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$11 */
    class C037111 extends TypeAdapter<Number> {
        C037111() {
        }

        @Override // com.google.gson.TypeAdapter
        public Number read(JsonReader in) throws IOException {
            if (in.peek() == JsonToken.NULL) {
                in.nextNull();
                return null;
            }
            try {
                return Long.valueOf(in.nextLong());
            } catch (NumberFormatException e) {
                throw new JsonSyntaxException(e);
            }
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter out, Number value) throws IOException {
            out.value(value);
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$12 */
    class C037212 extends TypeAdapter<Number> {
        C037212() {
        }

        @Override // com.google.gson.TypeAdapter
        public Number read(JsonReader in) throws IOException {
            if (in.peek() == JsonToken.NULL) {
                in.nextNull();
                return null;
            }
            return Float.valueOf((float) in.nextDouble());
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter out, Number value) throws IOException {
            out.value(value);
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$13 */
    class C037313 extends TypeAdapter<Number> {
        C037313() {
        }

        @Override // com.google.gson.TypeAdapter
        public Number read(JsonReader in) throws IOException {
            if (in.peek() == JsonToken.NULL) {
                in.nextNull();
                return null;
            }
            return Double.valueOf(in.nextDouble());
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter out, Number value) throws IOException {
            out.value(value);
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$14 */
    class C037414 extends TypeAdapter<Number> {
        C037414() {
        }

        @Override // com.google.gson.TypeAdapter
        public Number read(JsonReader in) throws IOException {
            JsonToken jsonToken = in.peek();
            int i = C039836.$SwitchMap$com$google$gson$stream$JsonToken[jsonToken.ordinal()];
            if (i == 1 || i == 3) {
                return new LazilyParsedNumber(in.nextString());
            }
            if (i == 4) {
                in.nextNull();
                return null;
            }
            throw new JsonSyntaxException("Expecting number, got: " + jsonToken);
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter out, Number value) throws IOException {
            out.value(value);
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$15 */
    class C037515 extends TypeAdapter<Character> {
        C037515() {
        }

        @Override // com.google.gson.TypeAdapter
        public Character read(JsonReader in) throws IOException {
            if (in.peek() == JsonToken.NULL) {
                in.nextNull();
                return null;
            }
            String str = in.nextString();
            if (str.length() != 1) {
                throw new JsonSyntaxException("Expecting character, got: " + str);
            }
            return Character.valueOf(str.charAt(0));
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter out, Character value) throws IOException {
            out.value(value == null ? null : String.valueOf(value));
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$16 */
    class C037616 extends TypeAdapter<String> {
        C037616() {
        }

        @Override // com.google.gson.TypeAdapter
        public String read(JsonReader in) throws IOException {
            JsonToken peek = in.peek();
            if (peek == JsonToken.NULL) {
                in.nextNull();
                return null;
            }
            if (peek == JsonToken.BOOLEAN) {
                return Boolean.toString(in.nextBoolean());
            }
            return in.nextString();
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter out, String value) throws IOException {
            out.value(value);
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$17 */
    class C037717 extends TypeAdapter<BigDecimal> {
        C037717() {
        }

        @Override // com.google.gson.TypeAdapter
        public BigDecimal read(JsonReader in) throws IOException {
            if (in.peek() == JsonToken.NULL) {
                in.nextNull();
                return null;
            }
            try {
                return new BigDecimal(in.nextString());
            } catch (NumberFormatException e) {
                throw new JsonSyntaxException(e);
            }
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter out, BigDecimal value) throws IOException {
            out.value(value);
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$18 */
    class C037818 extends TypeAdapter<BigInteger> {
        C037818() {
        }

        @Override // com.google.gson.TypeAdapter
        public BigInteger read(JsonReader in) throws IOException {
            if (in.peek() == JsonToken.NULL) {
                in.nextNull();
                return null;
            }
            try {
                return new BigInteger(in.nextString());
            } catch (NumberFormatException e) {
                throw new JsonSyntaxException(e);
            }
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter out, BigInteger value) throws IOException {
            out.value(value);
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$19 */
    class C037919 extends TypeAdapter<StringBuilder> {
        C037919() {
        }

        @Override // com.google.gson.TypeAdapter
        public StringBuilder read(JsonReader in) throws IOException {
            if (in.peek() == JsonToken.NULL) {
                in.nextNull();
                return null;
            }
            return new StringBuilder(in.nextString());
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter out, StringBuilder value) throws IOException {
            out.value(value == null ? null : value.toString());
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$20 */
    class C038120 extends TypeAdapter<StringBuffer> {
        C038120() {
        }

        @Override // com.google.gson.TypeAdapter
        public StringBuffer read(JsonReader in) throws IOException {
            if (in.peek() == JsonToken.NULL) {
                in.nextNull();
                return null;
            }
            return new StringBuffer(in.nextString());
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter out, StringBuffer value) throws IOException {
            out.value(value == null ? null : value.toString());
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$21 */
    class C038221 extends TypeAdapter<URL> {
        C038221() {
        }

        @Override // com.google.gson.TypeAdapter
        public URL read(JsonReader in) throws IOException {
            if (in.peek() == JsonToken.NULL) {
                in.nextNull();
                return null;
            }
            String nextString = in.nextString();
            if ("null".equals(nextString)) {
                return null;
            }
            return new URL(nextString);
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter out, URL value) throws IOException {
            out.value(value == null ? null : value.toExternalForm());
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$22 */
    class C038322 extends TypeAdapter<URI> {
        C038322() {
        }

        @Override // com.google.gson.TypeAdapter
        public URI read(JsonReader in) throws IOException {
            if (in.peek() == JsonToken.NULL) {
                in.nextNull();
                return null;
            }
            try {
                String nextString = in.nextString();
                return "null".equals(nextString) ? null : new URI(nextString);
            } catch (URISyntaxException e) {
                throw new JsonIOException(e);
            }
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter out, URI value) throws IOException {
            out.value(value == null ? null : value.toASCIIString());
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$23 */
    class C038423 extends TypeAdapter<InetAddress> {
        C038423() {
        }

        @Override // com.google.gson.TypeAdapter
        public InetAddress read(JsonReader in) throws IOException {
            if (in.peek() == JsonToken.NULL) {
                in.nextNull();
                return null;
            }
            return InetAddress.getByName(in.nextString());
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter out, InetAddress value) throws IOException {
            out.value(value == null ? null : value.getHostAddress());
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$24 */
    class C038524 extends TypeAdapter<UUID> {
        C038524() {
        }

        @Override // com.google.gson.TypeAdapter
        public UUID read(JsonReader in) throws IOException {
            if (in.peek() == JsonToken.NULL) {
                in.nextNull();
                return null;
            }
            return UUID.fromString(in.nextString());
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter out, UUID value) throws IOException {
            out.value(value == null ? null : value.toString());
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$25 */
    class C038625 extends TypeAdapter<Currency> {
        C038625() {
        }

        @Override // com.google.gson.TypeAdapter
        public Currency read(JsonReader in) throws IOException {
            return Currency.getInstance(in.nextString());
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter out, Currency value) throws IOException {
            out.value(value.getCurrencyCode());
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$26 */
    class C038726 implements TypeAdapterFactory {
        C038726() {
        }

        @Override // com.google.gson.TypeAdapterFactory
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
            if (typeToken.getRawType() != Timestamp.class) {
                return null;
            }
            return new TypeAdapter<Timestamp>() { // from class: com.google.gson.internal.bind.TypeAdapters.26.1
                final /* synthetic */ TypeAdapter val$dateTypeAdapter;

                AnonymousClass1(TypeAdapter typeAdapter) {
                    typeAdapter = typeAdapter;
                }

                @Override // com.google.gson.TypeAdapter
                public Timestamp read(JsonReader in) throws IOException {
                    Date date = (Date) typeAdapter.read(in);
                    if (date != null) {
                        return new Timestamp(date.getTime());
                    }
                    return null;
                }

                @Override // com.google.gson.TypeAdapter
                public void write(JsonWriter out, Timestamp value) throws IOException {
                    typeAdapter.write(out, value);
                }
            };
        }

        /* renamed from: com.google.gson.internal.bind.TypeAdapters$26$1 */
        class AnonymousClass1 extends TypeAdapter<Timestamp> {
            final /* synthetic */ TypeAdapter val$dateTypeAdapter;

            AnonymousClass1(TypeAdapter typeAdapter) {
                typeAdapter = typeAdapter;
            }

            @Override // com.google.gson.TypeAdapter
            public Timestamp read(JsonReader in) throws IOException {
                Date date = (Date) typeAdapter.read(in);
                if (date != null) {
                    return new Timestamp(date.getTime());
                }
                return null;
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter out, Timestamp value) throws IOException {
                typeAdapter.write(out, value);
            }
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$27 */
    class C038827 extends TypeAdapter<Calendar> {
        private static final String DAY_OF_MONTH = "dayOfMonth";
        private static final String HOUR_OF_DAY = "hourOfDay";
        private static final String MINUTE = "minute";
        private static final String MONTH = "month";
        private static final String SECOND = "second";
        private static final String YEAR = "year";

        C038827() {
        }

        @Override // com.google.gson.TypeAdapter
        public Calendar read(JsonReader in) throws IOException, NumberFormatException {
            if (in.peek() == JsonToken.NULL) {
                in.nextNull();
                return null;
            }
            in.beginObject();
            int year = 0;
            int month = 0;
            int dayOfMonth = 0;
            int hourOfDay = 0;
            int minute = 0;
            int second = 0;
            while (in.peek() != JsonToken.END_OBJECT) {
                String name = in.nextName();
                int value = in.nextInt();
                if (YEAR.equals(name)) {
                    year = value;
                } else if (MONTH.equals(name)) {
                    month = value;
                } else if (DAY_OF_MONTH.equals(name)) {
                    dayOfMonth = value;
                } else if (HOUR_OF_DAY.equals(name)) {
                    hourOfDay = value;
                } else if (MINUTE.equals(name)) {
                    minute = value;
                } else if (SECOND.equals(name)) {
                    second = value;
                }
            }
            in.endObject();
            return new GregorianCalendar(year, month, dayOfMonth, hourOfDay, minute, second);
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter out, Calendar value) throws IOException {
            if (value == null) {
                out.nullValue();
                return;
            }
            out.beginObject();
            out.name(YEAR);
            out.value(value.get(1));
            out.name(MONTH);
            out.value(value.get(2));
            out.name(DAY_OF_MONTH);
            out.value(value.get(5));
            out.name(HOUR_OF_DAY);
            out.value(value.get(11));
            out.name(MINUTE);
            out.value(value.get(12));
            out.name(SECOND);
            out.value(value.get(13));
            out.endObject();
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$28 */
    class C038928 extends TypeAdapter<Locale> {
        C038928() {
        }

        @Override // com.google.gson.TypeAdapter
        public Locale read(JsonReader in) throws IOException {
            if (in.peek() == JsonToken.NULL) {
                in.nextNull();
                return null;
            }
            String locale = in.nextString();
            StringTokenizer tokenizer = new StringTokenizer(locale, "_");
            String language = null;
            String country = null;
            String variant = null;
            if (tokenizer.hasMoreElements()) {
                language = tokenizer.nextToken();
            }
            if (tokenizer.hasMoreElements()) {
                country = tokenizer.nextToken();
            }
            if (tokenizer.hasMoreElements()) {
                variant = tokenizer.nextToken();
            }
            if (country == null && variant == null) {
                return new Locale(language);
            }
            if (variant == null) {
                return new Locale(language, country);
            }
            return new Locale(language, country, variant);
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter out, Locale value) throws IOException {
            out.value(value == null ? null : value.toString());
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$29 */
    class C039029 extends TypeAdapter<JsonElement> {
        C039029() {
        }

        @Override // com.google.gson.TypeAdapter
        public JsonElement read(JsonReader in) throws IOException {
            switch (C039836.$SwitchMap$com$google$gson$stream$JsonToken[in.peek().ordinal()]) {
                case 1:
                    String number = in.nextString();
                    return new JsonPrimitive(new LazilyParsedNumber(number));
                case 2:
                    return new JsonPrimitive(Boolean.valueOf(in.nextBoolean()));
                case 3:
                    return new JsonPrimitive(in.nextString());
                case 4:
                    in.nextNull();
                    return JsonNull.INSTANCE;
                case 5:
                    JsonArray array = new JsonArray();
                    in.beginArray();
                    while (in.hasNext()) {
                        array.add(read(in));
                    }
                    in.endArray();
                    return array;
                case 6:
                    JsonObject object = new JsonObject();
                    in.beginObject();
                    while (in.hasNext()) {
                        object.add(in.nextName(), read(in));
                    }
                    in.endObject();
                    return object;
                default:
                    throw new IllegalArgumentException();
            }
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter out, JsonElement value) throws IOException {
            if (value == null || value.isJsonNull()) {
                out.nullValue();
                return;
            }
            if (value.isJsonPrimitive()) {
                JsonPrimitive primitive = value.getAsJsonPrimitive();
                if (primitive.isNumber()) {
                    out.value(primitive.getAsNumber());
                    return;
                } else if (primitive.isBoolean()) {
                    out.value(primitive.getAsBoolean());
                    return;
                } else {
                    out.value(primitive.getAsString());
                    return;
                }
            }
            if (value.isJsonArray()) {
                out.beginArray();
                Iterator<JsonElement> it = value.getAsJsonArray().iterator();
                while (it.hasNext()) {
                    write(out, it.next());
                }
                out.endArray();
                return;
            }
            if (value.isJsonObject()) {
                out.beginObject();
                for (Map.Entry<String, JsonElement> e : value.getAsJsonObject().entrySet()) {
                    out.name(e.getKey());
                    write(out, e.getValue());
                }
                out.endObject();
                return;
            }
            throw new IllegalArgumentException("Couldn't write " + value.getClass());
        }
    }

    private static final class EnumTypeAdapter<T extends Enum<T>> extends TypeAdapter<T> {
        private final Map<String, T> nameToConstant = new HashMap();
        private final Map<T, String> constantToName = new HashMap();

        public EnumTypeAdapter(Class<T> classOfT) {
            try {
                for (T constant : classOfT.getEnumConstants()) {
                    String name = constant.name();
                    SerializedName annotation = (SerializedName) classOfT.getField(name).getAnnotation(SerializedName.class);
                    if (annotation != null) {
                        name = annotation.value();
                        for (String alternate : annotation.alternate()) {
                            this.nameToConstant.put(alternate, constant);
                        }
                    }
                    this.nameToConstant.put(name, constant);
                    this.constantToName.put(constant, name);
                }
            } catch (NoSuchFieldException e) {
                throw new AssertionError(e);
            }
        }

        @Override // com.google.gson.TypeAdapter
        public T read(JsonReader in) throws IOException {
            if (in.peek() == JsonToken.NULL) {
                in.nextNull();
                return null;
            }
            return this.nameToConstant.get(in.nextString());
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter out, T value) throws IOException {
            out.value(value == null ? null : this.constantToName.get(value));
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$30 */
    class C039230 implements TypeAdapterFactory {
        C039230() {
        }

        @Override // com.google.gson.TypeAdapterFactory
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
            Class<? super T> rawType = typeToken.getRawType();
            if (!Enum.class.isAssignableFrom(rawType) || rawType == Enum.class) {
                return null;
            }
            if (!rawType.isEnum()) {
                rawType = rawType.getSuperclass();
            }
            return new EnumTypeAdapter(rawType);
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$31 */
    class C039331 implements TypeAdapterFactory {
        final /* synthetic */ TypeAdapter val$typeAdapter;

        C039331(TypeAdapter typeAdapter) {
            typeAdapter = typeAdapter;
        }

        @Override // com.google.gson.TypeAdapterFactory
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
            if (typeToken.equals(typeToken)) {
                return typeAdapter;
            }
            return null;
        }
    }

    public static <TT> TypeAdapterFactory newFactory(TypeToken<TT> type, TypeAdapter<TT> typeAdapter) {
        return new TypeAdapterFactory() { // from class: com.google.gson.internal.bind.TypeAdapters.31
            final /* synthetic */ TypeAdapter val$typeAdapter;

            C039331(TypeAdapter typeAdapter2) {
                typeAdapter = typeAdapter2;
            }

            @Override // com.google.gson.TypeAdapterFactory
            public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
                if (typeToken.equals(typeToken)) {
                    return typeAdapter;
                }
                return null;
            }
        };
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$32 */
    class C039432 implements TypeAdapterFactory {
        final /* synthetic */ Class val$type;
        final /* synthetic */ TypeAdapter val$typeAdapter;

        C039432(Class cls, TypeAdapter typeAdapter) {
            cls = cls;
            typeAdapter = typeAdapter;
        }

        @Override // com.google.gson.TypeAdapterFactory
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
            if (typeToken.getRawType() == cls) {
                return typeAdapter;
            }
            return null;
        }

        public String toString() {
            return "Factory[type=" + cls.getName() + ",adapter=" + typeAdapter + "]";
        }
    }

    public static <TT> TypeAdapterFactory newFactory(Class<TT> type, TypeAdapter<TT> typeAdapter) {
        return new TypeAdapterFactory() { // from class: com.google.gson.internal.bind.TypeAdapters.32
            final /* synthetic */ Class val$type;
            final /* synthetic */ TypeAdapter val$typeAdapter;

            C039432(Class type2, TypeAdapter typeAdapter2) {
                cls = type2;
                typeAdapter = typeAdapter2;
            }

            @Override // com.google.gson.TypeAdapterFactory
            public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
                if (typeToken.getRawType() == cls) {
                    return typeAdapter;
                }
                return null;
            }

            public String toString() {
                return "Factory[type=" + cls.getName() + ",adapter=" + typeAdapter + "]";
            }
        };
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$33 */
    class C039533 implements TypeAdapterFactory {
        final /* synthetic */ Class val$boxed;
        final /* synthetic */ TypeAdapter val$typeAdapter;
        final /* synthetic */ Class val$unboxed;

        C039533(Class cls, Class cls2, TypeAdapter typeAdapter) {
            cls = cls;
            cls = cls2;
            typeAdapter = typeAdapter;
        }

        @Override // com.google.gson.TypeAdapterFactory
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
            Class<? super T> rawType = typeToken.getRawType();
            if (rawType == cls || rawType == cls) {
                return typeAdapter;
            }
            return null;
        }

        public String toString() {
            return "Factory[type=" + cls.getName() + Marker.ANY_NON_NULL_MARKER + cls.getName() + ",adapter=" + typeAdapter + "]";
        }
    }

    public static <TT> TypeAdapterFactory newFactory(Class<TT> unboxed, Class<TT> boxed, TypeAdapter<? super TT> typeAdapter) {
        return new TypeAdapterFactory() { // from class: com.google.gson.internal.bind.TypeAdapters.33
            final /* synthetic */ Class val$boxed;
            final /* synthetic */ TypeAdapter val$typeAdapter;
            final /* synthetic */ Class val$unboxed;

            C039533(Class unboxed2, Class boxed2, TypeAdapter typeAdapter2) {
                cls = unboxed2;
                cls = boxed2;
                typeAdapter = typeAdapter2;
            }

            @Override // com.google.gson.TypeAdapterFactory
            public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
                Class<? super T> rawType = typeToken.getRawType();
                if (rawType == cls || rawType == cls) {
                    return typeAdapter;
                }
                return null;
            }

            public String toString() {
                return "Factory[type=" + cls.getName() + Marker.ANY_NON_NULL_MARKER + cls.getName() + ",adapter=" + typeAdapter + "]";
            }
        };
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$34 */
    class C039634 implements TypeAdapterFactory {
        final /* synthetic */ Class val$base;
        final /* synthetic */ Class val$sub;
        final /* synthetic */ TypeAdapter val$typeAdapter;

        C039634(Class cls, Class cls2, TypeAdapter typeAdapter) {
            cls = cls;
            cls = cls2;
            typeAdapter = typeAdapter;
        }

        @Override // com.google.gson.TypeAdapterFactory
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
            Class<? super T> rawType = typeToken.getRawType();
            if (rawType == cls || rawType == cls) {
                return typeAdapter;
            }
            return null;
        }

        public String toString() {
            return "Factory[type=" + cls.getName() + Marker.ANY_NON_NULL_MARKER + cls.getName() + ",adapter=" + typeAdapter + "]";
        }
    }

    public static <TT> TypeAdapterFactory newFactoryForMultipleTypes(Class<TT> base, Class<? extends TT> sub, TypeAdapter<? super TT> typeAdapter) {
        return new TypeAdapterFactory() { // from class: com.google.gson.internal.bind.TypeAdapters.34
            final /* synthetic */ Class val$base;
            final /* synthetic */ Class val$sub;
            final /* synthetic */ TypeAdapter val$typeAdapter;

            C039634(Class base2, Class sub2, TypeAdapter typeAdapter2) {
                cls = base2;
                cls = sub2;
                typeAdapter = typeAdapter2;
            }

            @Override // com.google.gson.TypeAdapterFactory
            public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
                Class<? super T> rawType = typeToken.getRawType();
                if (rawType == cls || rawType == cls) {
                    return typeAdapter;
                }
                return null;
            }

            public String toString() {
                return "Factory[type=" + cls.getName() + Marker.ANY_NON_NULL_MARKER + cls.getName() + ",adapter=" + typeAdapter + "]";
            }
        };
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$35 */
    class C039735 implements TypeAdapterFactory {
        final /* synthetic */ Class val$clazz;
        final /* synthetic */ TypeAdapter val$typeAdapter;

        C039735(Class cls, TypeAdapter typeAdapter) {
            cls = cls;
            typeAdapter = typeAdapter;
        }

        @Override // com.google.gson.TypeAdapterFactory
        public <T2> TypeAdapter<T2> create(Gson gson, TypeToken<T2> typeToken) {
            Class<? super T2> requestedType = typeToken.getRawType();
            if (!cls.isAssignableFrom(requestedType)) {
                return null;
            }
            return new TypeAdapter<T1>() { // from class: com.google.gson.internal.bind.TypeAdapters.35.1
                final /* synthetic */ Class val$requestedType;

                AnonymousClass1(Class requestedType2) {
                    cls = requestedType2;
                }

                @Override // com.google.gson.TypeAdapter
                public void write(JsonWriter out, T1 value) throws IOException {
                    typeAdapter.write(out, value);
                }

                @Override // com.google.gson.TypeAdapter
                public T1 read(JsonReader jsonReader) throws IOException {
                    T1 t1 = (T1) typeAdapter.read(jsonReader);
                    if (t1 != null && !cls.isInstance(t1)) {
                        throw new JsonSyntaxException("Expected a " + cls.getName() + " but was " + t1.getClass().getName());
                    }
                    return t1;
                }
            };
        }

        /* renamed from: com.google.gson.internal.bind.TypeAdapters$35$1 */
        class AnonymousClass1<T1> extends TypeAdapter<T1> {
            final /* synthetic */ Class val$requestedType;

            AnonymousClass1(Class requestedType2) {
                cls = requestedType2;
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter out, T1 value) throws IOException {
                typeAdapter.write(out, value);
            }

            @Override // com.google.gson.TypeAdapter
            public T1 read(JsonReader jsonReader) throws IOException {
                T1 t1 = (T1) typeAdapter.read(jsonReader);
                if (t1 != null && !cls.isInstance(t1)) {
                    throw new JsonSyntaxException("Expected a " + cls.getName() + " but was " + t1.getClass().getName());
                }
                return t1;
            }
        }

        public String toString() {
            return "Factory[typeHierarchy=" + cls.getName() + ",adapter=" + typeAdapter + "]";
        }
    }

    public static <T1> TypeAdapterFactory newTypeHierarchyFactory(Class<T1> clazz, TypeAdapter<T1> typeAdapter) {
        return new TypeAdapterFactory() { // from class: com.google.gson.internal.bind.TypeAdapters.35
            final /* synthetic */ Class val$clazz;
            final /* synthetic */ TypeAdapter val$typeAdapter;

            C039735(Class clazz2, TypeAdapter typeAdapter2) {
                cls = clazz2;
                typeAdapter = typeAdapter2;
            }

            @Override // com.google.gson.TypeAdapterFactory
            public <T2> TypeAdapter<T2> create(Gson gson, TypeToken<T2> typeToken) {
                Class requestedType2 = typeToken.getRawType();
                if (!cls.isAssignableFrom(requestedType2)) {
                    return null;
                }
                return new TypeAdapter<T1>() { // from class: com.google.gson.internal.bind.TypeAdapters.35.1
                    final /* synthetic */ Class val$requestedType;

                    AnonymousClass1(Class requestedType22) {
                        cls = requestedType22;
                    }

                    @Override // com.google.gson.TypeAdapter
                    public void write(JsonWriter out, T1 value) throws IOException {
                        typeAdapter.write(out, value);
                    }

                    @Override // com.google.gson.TypeAdapter
                    public T1 read(JsonReader jsonReader) throws IOException {
                        T1 t1 = (T1) typeAdapter.read(jsonReader);
                        if (t1 != null && !cls.isInstance(t1)) {
                            throw new JsonSyntaxException("Expected a " + cls.getName() + " but was " + t1.getClass().getName());
                        }
                        return t1;
                    }
                };
            }

            /* renamed from: com.google.gson.internal.bind.TypeAdapters$35$1 */
            class AnonymousClass1<T1> extends TypeAdapter<T1> {
                final /* synthetic */ Class val$requestedType;

                AnonymousClass1(Class requestedType22) {
                    cls = requestedType22;
                }

                @Override // com.google.gson.TypeAdapter
                public void write(JsonWriter out, T1 value) throws IOException {
                    typeAdapter.write(out, value);
                }

                @Override // com.google.gson.TypeAdapter
                public T1 read(JsonReader jsonReader) throws IOException {
                    T1 t1 = (T1) typeAdapter.read(jsonReader);
                    if (t1 != null && !cls.isInstance(t1)) {
                        throw new JsonSyntaxException("Expected a " + cls.getName() + " but was " + t1.getClass().getName());
                    }
                    return t1;
                }
            }

            public String toString() {
                return "Factory[typeHierarchy=" + cls.getName() + ",adapter=" + typeAdapter + "]";
            }
        };
    }
}
