import com.esde.cubes.creator.CubeFactory;
import com.esde.cubes.creator.impl.CubeFactoryImpl;
import com.esde.cubes.exception.InvalidCubeDataException;
import com.esde.cubes.model.Cube;
import com.esde.cubes.model.CubeState;
import com.esde.cubes.service.CubeService;
import com.esde.cubes.service.impl.CubeServiceImpl;
import com.esde.cubes.util.TxtParser;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CubeTest {
    private final static String TEST_DATA = "/test/testData.txt";
    private final static String INVALID_TEST_DATA = "/test/invalidData.txt";
    private final static String FACTORY_TEST_DATA = "/test/factoryTest.txt";

    //Test TxtParser
    @Test
    void testCorrectTxtParser() throws InvalidCubeDataException {
        Double[] cube = {1.1, 2.2, 3.3, 4.4};
        List<Double[]> parameters = TxtParser.parseCubesTxt(TEST_DATA);

        assertEquals(Arrays.toString(cube), Arrays.toString(parameters.getFirst()));
    }

    @Test
    void testIncorrectTxtParser() throws InvalidCubeDataException {
        List<Double[]> parameters = TxtParser.parseCubesTxt(INVALID_TEST_DATA);

        assertEquals("[]", parameters.toString());
    }

    //Test CubeFactory
    @Test
    void testCubeFactory() {
        CubeFactory factory = new CubeFactoryImpl();
        List<Cube> result = factory.createCubes(FACTORY_TEST_DATA);

        assertEquals(2, result.size());
        assertEquals(CubeState.VALID, result.get(0).getState());
        assertEquals(CubeState.VALID, result.get(1).getState());
    }

    //Test CubeState
    @Test
    void testValid() {
        Cube cube = new Cube(1.0, 1.0, 1.0, 5);

        assertEquals(CubeState.VALID, cube.getState());
    }


    @Test
    void testInvalid() {
        Cube cube = new Cube(7, 1, 1, -1);

        assertEquals(CubeState.INVALID, cube.getState());
    }

    //Test CubeService
    @Test
    void testVolume() {
        CubeService cubeService = new CubeServiceImpl();
        Cube cube = new Cube(1.0, 1.0, 1.0, 5);

        assertEquals(125, cubeService.volume(cube));
    }

    @Test
    void testSurfaceArea() {
        CubeService cubeService = new CubeServiceImpl();
        Cube cube = new Cube(1.0, 1.0, 1.0, 5);

        assertEquals(150, cubeService.surfaceArea(cube));
    }

    //Test CubeObserver
    @Test
    void testCubeObserver() {
        CubeService service = new CubeServiceImpl();
        Cube cube = new Cube(1.0, 1.0, 1.0, 5);

        assertEquals(125, service.volume(cube));
        cube.setSide(6);
        assertEquals(216, service.volume(cube));
    }

}

