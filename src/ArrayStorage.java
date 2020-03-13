/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        for (int i = 0; i < this.size(); i++) {
            this.storage[i] = null;
        }
    }

    void save(Resume r) {
        this.storage[this.size()] = r;
    }

    Resume get(String uuid) {
        try {
            for (int i = 0; i < this.size(); i++) {
                if (this.storage[i].toString().equals(uuid)) {
                    return this.storage[i];
                }
            }
        } catch (NullPointerException npe) {
            System.out.println("UUID not found!");
        }

        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i < this.size(); i++) {
            if (this.storage[i].toString().equals(uuid)) {
                for (int j = i; j < this.size() - 1; j++) {
                    this.storage[j] = this.storage[j + 1];
                }
                this.storage[this.size() - 1] = null;
                break;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] allCV = new Resume[this.size()];
        System.arraycopy(this.storage, 0, allCV, 0, this.size());
        return allCV;
    }

    int size() {
        int size = 0;
        while (this.storage[size] != null) {
            size++;
        }
        return size;
    }
}
