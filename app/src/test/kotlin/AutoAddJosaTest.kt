import kotlin.test.Test
import kotlin.test.assertEquals

class AutoAddJosaTest {

    @Test
    fun `은는 조사 테스트`() {
        assertEquals("사과는", "사과".josa(Josa.은는))
        assertEquals("밥은", "밥".josa(Josa.은는))
    }

    @Test
    fun `이가 조사 테스트`() {
        assertEquals("책이", "책".josa(Josa.이가))
        assertEquals("바나나가", "바나나".josa(Josa.이가))
    }

    @Test
    fun `을를 조사 테스트`() {
        assertEquals("문자열을", "문자열".josa(Josa.을를))
        assertEquals("사과를", "사과".josa(Josa.을를))
    }

    @Test
    fun `와과 조사 테스트`() {
        assertEquals("학교와", "학교".josa(Josa.와과))
        assertEquals("친구와", "친구".josa(Josa.와과))
    }

    @Test
    fun `으로 조사 테스트 - ㄹ 받침 특례`() {
        assertEquals("산으로", "산".josa(Josa.으로))
        assertEquals("길로", "길".josa(Josa.으로)) // ㄹ 받침 특례
    }

    @Test
    fun `빈 문자열 테스트`() {
        assertEquals("", "".josa(Josa.은는))
    }
}
