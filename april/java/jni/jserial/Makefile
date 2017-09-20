GCC = clang -Wall -g -std=gnu99
LIB_APRIL_JSERIAL_OBJS = serial.o serial_jni.o ioutils.o

LIB=libjserial.dylib
DESTLIB=../../../lib/$(LIB)

all: $(DESTLIB)


$(DESTLIB): $(LIB)
	cp $(LIB) $(DESTLIB)

libjserial.dylib: april_jserial_JSerial.h $(LIB_APRIL_JSERIAL_OBJS)
	ld --shared $(LIB_APRIL_JSERIAL_OBJS) -o libjserial.dylib

april_jserial_JSerial.h:
	echo "Rebuilding JNI headers. Ensure java file has been recently built."
	javah -classpath ../../april.jar  april.jserial.JSerial

clean:
	rm -f $(LIB_APRIL_JSERIAL_OBJS) *~ april_jserial_JSerial.h *.so $(LIB) $(LDESTLIB)

JNI_INCLUDES = -I${JAVA_HOME}/include -I${JAVA_HOME}/include/darwin

%.o: %.c
	$(GCC) -shared -O2 -c -fPIC -fno-omit-frame-pointer -fno-stack-protector -D_REENTRANT $< $(JNI_INCLUDES)
