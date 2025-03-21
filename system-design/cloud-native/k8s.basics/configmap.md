1. ConfigMap creation and inject into pod env
  
   1.1. ConfigMap and Inject to a Pod

   1.2. ConfigMap and Deployment

   1.3. Additional Examples on ConfigMap
   
   1.4. Debugging Tips for ConfigMap

   1.5. ConfigMap Inject to Pod using Volume Mount

   1.6. Why PVC not required when ConfigMap mounted using a volume 
   

2. Secret creation and inject into pod env
3. Consume Secret from AWS secret manager.


To create a ConfigMap in Kubernetes and inject its values into a pod’s environment variables, follow these steps:

---

## ConfigMap and Inject to a Pod

### Step 1: Create a ConfigMap
You can create a ConfigMap from a YAML file or directly from the command line.

#### Using YAML:
Create a file named `configmap.yaml`:
```yaml
apiVersion: v1
kind: ConfigMap
metadata:
  name: example-config
data:
  APP_ENV: production
  APP_DEBUG: "false"
  APP_VERSION: "1.0"
```

Apply the ConfigMap:
```bash
kubectl apply -f configmap.yaml
```

#### Using Command Line:
```bash
kubectl create configmap example-config --from-literal=APP_ENV=production --from-literal=APP_DEBUG=false --from-literal=APP_VERSION=1.0
```

---

### Step 2: Inject the ConfigMap into Pod Environment Variables
Edit the pod or deployment definition to reference the ConfigMap.

Create a file named `pod.yaml`:
```yaml
apiVersion: v1
kind: Pod
metadata:
  name: example-pod
spec:
  containers:
  - name: app-container
    image: nginx
    env:
    - name: APP_ENV
      valueFrom:
        configMapKeyRef:
          name: example-config
          key: APP_ENV
    - name: APP_DEBUG
      valueFrom:
        configMapKeyRef:
          name: example-config
          key: APP_DEBUG
    - name: APP_VERSION
      valueFrom:
        configMapKeyRef:
          name: example-config
          key: APP_VERSION
```

Apply the Pod configuration:
```bash
kubectl apply -f pod.yaml
```

---

### Step 3: Verify the Configuration
1. Check if the pod is running:
   ```bash
   kubectl get pods
   ```
2. View the logs or inspect the pod to confirm the environment variables:
   ```bash
   kubectl exec -it example-pod -- env
   ```

You should see the `APP_ENV`, `APP_DEBUG`, and `APP_VERSION` variables in the environment of the container.

---

### Notes:
- If you want to inject **all key-value pairs** in a ConfigMap into a container’s environment variables, use `envFrom`:
```yaml
envFrom:
- configMapRef:
    name: example-config
```
- Use `configMapKeyRef` when you need to specify individual keys.

## ConfigMap and deployment

Here's how you can inject a ConfigMap into a **Deployment**:

---

### Step 1: Create the ConfigMap
(If you don't already have a ConfigMap, use the one from the previous example.)

`configmap.yaml`:
```yaml
apiVersion: v1
kind: ConfigMap
metadata:
  name: example-config
data:
  APP_ENV: production
  APP_DEBUG: "false"
  APP_VERSION: "1.0"
```

Apply the ConfigMap:
```bash
kubectl apply -f configmap.yaml
```

---

### Step 2: Create the Deployment
Here's an example Deployment configuration that uses the ConfigMap:

`deployment.yaml`:
```yaml
apiVersion: apps/v1
kind: Deployment
metadata:
  name: example-deployment
spec:
  replicas: 2
  selector:
    matchLabels:
      app: example-app
  template:
    metadata:
      labels:
        app: example-app
    spec:
      containers:
      - name: app-container
        image: nginx
        env:
        - name: APP_ENV
          valueFrom:
            configMapKeyRef:
              name: example-config
              key: APP_ENV
        - name: APP_DEBUG
          valueFrom:
            configMapKeyRef:
              name: example-config
              key: APP_DEBUG
        - name: APP_VERSION
          valueFrom:
            configMapKeyRef:
              name: example-config
              key: APP_VERSION
```

Apply the Deployment:
```bash
kubectl apply -f deployment.yaml
```

---

### Step 3: Verify the Deployment
1. **Check the Deployment and Pods**:
   ```bash
   kubectl get deployments
   kubectl get pods
   ```
2. **Inspect a Pod's Environment Variables**:
   Pick one of the pods created by the Deployment and check its environment variables:
   ```bash
   kubectl exec -it <pod-name> -- env
   ```

   Replace `<pod-name>` with the name of the pod, which you can find using `kubectl get pods`.

---

### Using `envFrom` to Inject All ConfigMap Keys
If you want to inject all key-value pairs from the ConfigMap without specifying them individually, modify the container spec like this:
```yaml
envFrom:
- configMapRef:
    name: example-config
```

Updated `deployment.yaml`:
```yaml
apiVersion: apps/v1
kind: Deployment
metadata:
  name: example-deployment
spec:
  replicas: 2
  selector:
    matchLabels:
      app: example-app
  template:
    metadata:
      labels:
        app: example-app
    spec:
      containers:
      - name: app-container
        image: nginx
        envFrom:
        - configMapRef:
            name: example-config
```

Apply the updated Deployment:
```bash
kubectl apply -f deployment.yaml
```

---

Would you like additional examples or assistance with debugging this setup?Alright! Here are additional examples and some debugging tips to help you set up and troubleshoot ConfigMap usage in a Deployment.

---

## Additional Examples On ConfigMap

#### **Example 1: Default Values for Missing ConfigMap Keys**
If a ConfigMap key is missing but your application expects it, you can provide a default value using the `value` field:
```yaml
env:
- name: APP_PORT
  value: "8080" # Default value if ConfigMap key is missing
- name: APP_ENV
  valueFrom:
    configMapKeyRef:
      name: example-config
      key: APP_ENV
```

---

#### **Example 2: Combine ConfigMap with Secrets**
Sometimes, you need to combine ConfigMap for non-sensitive data and Secrets for sensitive data:
```yaml
env:
- name: APP_ENV
  valueFrom:
    configMapKeyRef:
      name: example-config
      key: APP_ENV
- name: DATABASE_PASSWORD
  valueFrom:
    secretKeyRef:
      name: example-secret
      key: DB_PASSWORD
```

---

#### **Example 3: Override ConfigMap Values in Deployment**
You can override some ConfigMap values in the Deployment file:
```yaml
env:
- name: APP_ENV
  value: "staging" # Overrides the ConfigMap value
- name: APP_DEBUG
  valueFrom:
    configMapKeyRef:
      name: example-config
      key: APP_DEBUG
```

---

## **Debugging Tips for ConfigMap**

#### 1. **Ensure the ConfigMap Exists**
Run the following to confirm your ConfigMap is created and contains the expected data:
```bash
kubectl get configmap example-config -o yaml
```

---

#### 2. **Inspect Pod Events**
If your pod isn't starting or behaving as expected, check its events:
```bash
kubectl describe pod <pod-name>
```
Look for issues like missing ConfigMap keys or permission errors.

---

#### 3. **Check Pod Environment Variables**
Verify that the environment variables are injected into the pod:
```bash
kubectl exec -it <pod-name> -- env
```

---

#### 4. **View Deployment and Pod YAML**
If the pods aren’t getting the ConfigMap values, inspect the effective YAML:
```bash
kubectl get deployment example-deployment -o yaml
kubectl get pod <pod-name> -o yaml
```

---

#### 5. **Debug Using Logs**
Inspect the logs of your application container to identify any runtime issues related to the missing or misconfigured environment variables:
```bash
kubectl logs <pod-name>
```

## ConfigMap Inject to Pod using Volume Mount

To inject a ConfigMap into a pod using a volume mount, you can follow these steps:

---

### 1. **Create the ConfigMap**
You can create a ConfigMap in the same way as before:

```yaml
apiVersion: v1
kind: ConfigMap
metadata:
  name: example-config
data:
  APP_ENV: production
  APP_DEBUG: "false"
  APP_VERSION: "1.0"
```

Apply the ConfigMap:
```bash
kubectl apply -f configmap.yaml
```

---

### 2. **Inject ConfigMap into Pod Using Volume Mount**

Modify the pod or deployment definition to mount the ConfigMap as a volume.

```yaml
apiVersion: v1
kind: Pod
metadata:
  name: example-pod
spec:
  containers:
  - name: app-container
    image: nginx
    volumeMounts:
    - name: config-volume
      mountPath: /etc/config
      readOnly: true
  volumes:
  - name: config-volume
    configMap:
      name: example-config
```

In this example:
- **Volume** is created from the ConfigMap (`configMap`).
- **Volume mount** is specified in the container (`mountPath: /etc/config`).

---

### 3. **Apply the Pod Configuration**

```bash
kubectl apply -f pod.yaml
```

---

### 4. **Verify the ConfigMap Volume in the Pod**

Once the pod is running, verify that the ConfigMap is mounted as files inside the container.

```bash
kubectl exec -it <pod-name> -- ls /etc/config
```

You should see files corresponding to the keys in the ConfigMap (`APP_ENV`, `APP_DEBUG`, `APP_VERSION`).

---

### 5. **Access the ConfigMap Values Inside the Container**

Inside the pod, the ConfigMap keys will appear as files with their content as the file content. You can access them like regular files:
```bash
kubectl exec -it <pod-name> -- cat /etc/config/APP_ENV
```

---

This approach allows the application inside the container to read the ConfigMap data from mounted files instead of environment variables.




---

## Why PVC not required when ConfigMap mounted using a volume 

In Kubernetes, you can mount a ConfigMap as a volume without the need for a **PersistentVolumeClaim (PVC)** because a ConfigMap itself is an in-memory resource, not requiring persistent storage.

When you use a ConfigMap in this way, Kubernetes creates an in-memory volume that contains the ConfigMap's data, and this volume is mounted to the pod. Since ConfigMaps are designed to be small and not persist across pod restarts (unless explicitly recreated), you don't need a PVC to back it.

### **Key Points:**
- **No PVC required**: ConfigMaps are not tied to persistent storage, they are in-memory resources.
- **ConfigMap as Volume**: The ConfigMap is directly mounted as a volume into your container.

Here’s how it works:

---

### Example of ConfigMap Volume Mount without PVC

```yaml
apiVersion: v1
kind: Pod
metadata:
  name: example-pod
spec:
  containers:
  - name: app-container
    image: nginx
    volumeMounts:
    - name: config-volume
      mountPath: /etc/config
      readOnly: true
  volumes:
  - name: config-volume
    configMap:
      name: example-config
```

#### Breakdown:
- **`volumes`**: Specifies that the `example-config` ConfigMap should be mounted as a volume.
- **`volumeMounts`**: Specifies where in the container's filesystem the volume will be mounted (`/etc/config` in this case).

The ConfigMap’s keys (like `APP_ENV`, `APP_DEBUG`, etc.) will be available as files in the `/etc/config` directory.

---

### No Persistent Volume Involved
- **PersistentVolume (PV)** and **PersistentVolumeClaim (PVC)** are used when you need to store data that survives pod restarts or when you need to use external storage (like a disk or cloud storage).
- **ConfigMap Volume** is an ephemeral, in-memory volume that gets mounted directly into the pod and doesn't need a PVC.

---

### Verification:
To verify the mounted ConfigMap, you can check the contents of the mounted directory in the pod:

```bash
kubectl exec -it <pod-name> -- ls /etc/config
```

You should see files named after the keys in the ConfigMap (e.g., `APP_ENV`, `APP_DEBUG`, `APP_VERSION`), and the file contents will be the values of the respective keys.

Let me know if you need further details!

