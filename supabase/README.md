# Supabase Storage configuration

Bucket: `documents`  
Public access: disabled  
Allowed files: PDF, JPG, PNG up to 10 MB

Security model used by the app:

- The Android app saves document metadata locally first.
- The backend uploads the real file to Supabase Storage using `SUPABASE_SERVICE_ROLE_KEY` from the server environment only.
- The database stores metadata: file name, storage path, MIME type, size, patient association, upload date, sync status and bucket.
- The service role key must never be used in Android/frontend code.

Temporary setup token:

```bash
export SUPABASE_ACCESS_TOKEN="PEGAR_TOKEN_TEMPORAL_AQUI"
```

Use the token only to link/configure Supabase, then remove it from the shell. Do not write it to project files.

Required backend environment variables:

```bash
SUPABASE_URL="https://<project-ref>.supabase.co"
SUPABASE_SERVICE_ROLE_KEY="<server-side-service-role-key>"
SUPABASE_STORAGE_BUCKET="documents"
```

Apply `storage-policies.sql` in Supabase SQL editor or through the CLI after linking the project.
