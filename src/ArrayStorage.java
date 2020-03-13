/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int size = 0;

    void clear() {
        for (int i = 0; i < size(); i++) {
            storage[i] = null;
        }
        size = 0;
    }

    void save(Resume r) {
        storage[size()] = r;
        size++;
    }

    Resume get(String uuid) {
            for (int i = 0; i < size(); i++) {
                if (storage[i].toString().equals(uuid)) {
                    return storage[i];
                }
            }
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i < size(); i++) {
            if (storage[i].toString().equals(uuid)) {
                for (int j = i; j < size() - 1; j++) {
                    storage[j] = storage[j + 1];
                }
                storage[size() - 1] = null;
                size--;
                break;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] allCV = new Resume[size()];
        System.arraycopy(storage, 0, allCV, 0, size());
        return allCV;
    }

    int size() {
        return size;
    }
}
